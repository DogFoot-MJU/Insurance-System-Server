package com.dogfoot.insurancesystemserver.domain.productdevelopment.dto;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.CarProductDevelopment;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

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

    public static ProductPlanDevelopmentResponse from(CarProductDevelopment carProductDevelopment) {
        return ProductPlanDevelopmentResponse.builder()
                .id(carProductDevelopment.getId())
                .name(carProductDevelopment.getName())
                .payment(carProductDevelopment.getPayment())
                .state(carProductDevelopment.getState())
                .build();
    }

}
