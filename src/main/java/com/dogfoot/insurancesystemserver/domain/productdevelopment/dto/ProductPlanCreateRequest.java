package com.dogfoot.insurancesystemserver.domain.productdevelopment.dto;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.CarProductDevelopment;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

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

    public CarProductDevelopment toEntity() {
        return CarProductDevelopment.builder()
                .name(this.name)
                .payment(this.payment)
                .build();
    }

}
