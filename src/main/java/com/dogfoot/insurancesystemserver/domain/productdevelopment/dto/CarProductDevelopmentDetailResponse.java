package com.dogfoot.insurancesystemserver.domain.productdevelopment.dto;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.CarProductDevelopment;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
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
public class CarProductDevelopmentDetailResponse {

    private Long id;
    private String name;
    private Long payment;
    private DevelopmentState state;
    private Long carPrice;
    private LocalDate carReleaseDate;
    private Long drivingDistance;

    public static CarProductDevelopmentDetailResponse from(CarProductDevelopment carProductDevelopment) {
        return CarProductDevelopmentDetailResponse.builder()
                .id(carProductDevelopment.getId())
                .name(carProductDevelopment.getName())
                .payment(carProductDevelopment.getPayment())
                .state(carProductDevelopment.getState())
                .carPrice(carProductDevelopment.getCarPrice())
                .carReleaseDate(carProductDevelopment.getCarReleaseDate())
                .drivingDistance(carProductDevelopment.getDrivingDistance())
                .build();
    }

}
