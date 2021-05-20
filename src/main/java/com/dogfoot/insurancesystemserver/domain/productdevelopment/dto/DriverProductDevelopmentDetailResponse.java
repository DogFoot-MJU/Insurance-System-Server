package com.dogfoot.insurancesystemserver.domain.productdevelopment.dto;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.DriverLicence;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DriverDevelopment;
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
public class DriverProductDevelopmentDetailResponse {

    private final Long id;
    private final String name;
    private final Long payment;
    private final DevelopmentState state;
    private final LocalDate DateOfLicenseAcquisition;
    private final DriverLicence driverLicence;

    public static DriverProductDevelopmentDetailResponse from(DriverDevelopment driverDevelopment) {
        return DriverProductDevelopmentDetailResponse.builder()
                .id(driverDevelopment.getId())
                .name(driverDevelopment.getName())
                .payment(driverDevelopment.getPayment())
                .state(driverDevelopment.getState())
                .DateOfLicenseAcquisition(driverDevelopment.getDateOfLicenseAcquisition())
                .driverLicence(driverDevelopment.getDriverLicence())
                .build();
    }

}
