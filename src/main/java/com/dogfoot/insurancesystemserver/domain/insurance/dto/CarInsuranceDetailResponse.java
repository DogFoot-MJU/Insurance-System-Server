package com.dogfoot.insurancesystemserver.domain.insurance.dto;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.CarInsurance;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CarInsuranceDetailResponse {

    private final Long id;
    private final String name;
    private final Long payment;
    private final String physical;
    private final String economical;
    private final String environmental;
    private final boolean isAvailableSale;
    private final Long carPrice;
    private final LocalDate carReleaseDate;
    private final Long drivingDistance;

    public static CarInsuranceDetailResponse from(CarInsurance carInsurance) {
        return CarInsuranceDetailResponse.builder()
                .id(carInsurance.getId())
                .name(carInsurance.getName())
                .payment(carInsurance.getPayment())
                .physical(carInsurance.getCapacityPolicy().getPhysical())
                .economical(carInsurance.getCapacityPolicy().getEconomical())
                .environmental(carInsurance.getCapacityPolicy().getEnvironmental())
                .isAvailableSale(carInsurance.isAvailableSale())
                .carPrice(carInsurance.getCarPrice())
                .carReleaseDate(carInsurance.getCarReleaseDate())
                .drivingDistance(carInsurance.getDrivingDistance())
                .build();
    }

}
