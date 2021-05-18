package com.dogfoot.insurancesystemserver.domain.productdevelopment.dto;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.CarProductDevelopment;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DriverProductDevelopment;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.FireProductDevelopment;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.TravelProductDevelopment;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProductPlanCreateRequest {

    @NotBlank
    private String name;

    @NotNull
    private Long payment;

    public CarProductDevelopment toCarProductDevelopmentEntity() {
        return CarProductDevelopment.builder()
                .name(this.name)
                .payment(this.payment)
                .build();
    }

    public DriverProductDevelopment toDriverProductDevelopmentEntity() {
        return DriverProductDevelopment.builder()
                .name(this.name)
                .payment(this.payment)
                .build();
    }

    public FireProductDevelopment toFireProductDevelopmentEntity() {
        return FireProductDevelopment.builder()
                .name(this.name)
                .payment(this.payment)
                .build();
    }

    public TravelProductDevelopment toTravelProductDevelopmentEntity() {
        return TravelProductDevelopment.builder()
                .name(this.name)
                .payment(this.payment)
                .build();
    }

}
