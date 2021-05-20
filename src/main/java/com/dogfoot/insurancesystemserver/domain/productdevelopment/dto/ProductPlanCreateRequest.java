package com.dogfoot.insurancesystemserver.domain.productdevelopment.dto;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.*;
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

    public <T extends ProductDevelopment> T toEntity(Class<T> clazz) {
        T t = null;
        try {
            t = clazz.getConstructor(String.class, Long.class).newInstance(name, payment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public CarDevelopment toCarProductDevelopmentEntity() {
        return CarDevelopment.builder()
                .name(this.name)
                .payment(this.payment)
                .build();
    }

    public DriverDevelopment toDriverProductDevelopmentEntity() {
        return DriverDevelopment.builder()
                .name(this.name)
                .payment(this.payment)
                .build();
    }

    public FireDevelopment toFireProductDevelopmentEntity() {
        return FireDevelopment.builder()
                .name(this.name)
                .payment(this.payment)
                .build();
    }

    public TravelDevelopment toTravelProductDevelopmentEntity() {
        return TravelDevelopment.builder()
                .name(this.name)
                .payment(this.payment)
                .build();
    }

}
