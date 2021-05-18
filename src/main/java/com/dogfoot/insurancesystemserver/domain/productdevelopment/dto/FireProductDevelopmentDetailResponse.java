package com.dogfoot.insurancesystemserver.domain.productdevelopment.dto;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.FireProductDevelopment;
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
public class FireProductDevelopmentDetailResponse {

    private final Long id;
    private final String name;
    private final Long payment;
    private final DevelopmentState state;
    private final Long buildingPrice;
    private final LocalDate constructionDate;
    private final Long siteArea;
    private final Integer numberOfFloors;

    public static FireProductDevelopmentDetailResponse from(FireProductDevelopment fireProductDevelopment) {
        return FireProductDevelopmentDetailResponse.builder()
                .id(fireProductDevelopment.getId())
                .name(fireProductDevelopment.getName())
                .payment(fireProductDevelopment.getPayment())
                .state(fireProductDevelopment.getState())
                .buildingPrice(fireProductDevelopment.getBuildingPrice())
                .constructionDate(fireProductDevelopment.getConstructionDate())
                .siteArea(fireProductDevelopment.getSiteArea())
                .numberOfFloors(fireProductDevelopment.getNumberOfFloors())
                .build();
    }


}
