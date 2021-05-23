package com.dogfoot.insurancesystemserver.domain.insurance.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
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

//    public static CarInsuranceDetailResponse from(CarInsurance insurance) {
//        return CarInsuranceDetailResponse.builder()
//                .id(insurance.getId())
//                .name(insurance.getName())
//                .payment(insurance.getPayment())
//                .physical(insurance.getCapacityPolicy().getPhysical())
//                .economical(insurance.getCapacityPolicy().getEconomical())
//                .environmental(insurance.getCapacityPolicy().getEnvironmental())
//                .isAvailableSale(insurance.isAvailableSale())
//                .carPrice(insurance.getCarPrice())
//                .carReleaseDate(insurance.getCarReleaseDate())
//                .drivingDistance(insurance.getDrivingDistance())
//                .build();
//    }

}
