package com.dogfoot.insurancesystemserver.domain.productdevelopment.dto;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.*;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProductPlanDevelopmentResponse {

    private Long id;
    private String name;
    private Long payment;
    private DevelopmentState state;

    public static ProductPlanDevelopmentResponse from(CarDevelopment entity) {
        return ProductPlanDevelopmentResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .payment(entity.getPayment())
                .state(entity.getState())
                .build();
    }

    public static ProductPlanDevelopmentResponse from(DriverDevelopment entity) {
        return ProductPlanDevelopmentResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .payment(entity.getPayment())
                .state(entity.getState())
                .build();
    }

    public static ProductPlanDevelopmentResponse from(ProductDevelopment entity) {
        return ProductPlanDevelopmentResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .payment(entity.getPayment())
                .state(entity.getState())
                .build();
    }

    public static ProductPlanDevelopmentResponse from(TravelDevelopment entity) {
        return ProductPlanDevelopmentResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .payment(entity.getPayment())
                .state(entity.getState())
                .build();
    }
}
