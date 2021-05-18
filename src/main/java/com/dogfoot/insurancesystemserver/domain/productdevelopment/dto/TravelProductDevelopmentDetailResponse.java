package com.dogfoot.insurancesystemserver.domain.productdevelopment.dto;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.SafetyRank;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.TravelProductDevelopment;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TravelProductDevelopmentDetailResponse {

    private final Long id;
    private final String name;
    private final Long payment;
    private final DevelopmentState state;
    private final SafetyRank safetyRank;

    public static TravelProductDevelopmentDetailResponse from(TravelProductDevelopment travelProductDevelopment) {
        return TravelProductDevelopmentDetailResponse.builder()
                .id(travelProductDevelopment.getId())
                .name(travelProductDevelopment.getName())
                .payment(travelProductDevelopment.getPayment())
                .state(travelProductDevelopment.getState())
                .safetyRank(travelProductDevelopment.getSafetyRank())
                .build();
    }
}
