package com.dogfoot.insurancesystemserver.domain.productdevelopment.dto;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.SafetyRank;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.TravelDevelopment;
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
    private final int expirationDate;
    private final DevelopmentState state;
    private final SafetyRank safetyRank;

    public static TravelProductDevelopmentDetailResponse from(TravelDevelopment travelDevelopment) {
        return TravelProductDevelopmentDetailResponse.builder()
                .id(travelDevelopment.getId())
                .name(travelDevelopment.getName())
                .payment(travelDevelopment.getPayment())
                .expirationDate(travelDevelopment.getExpirationDate())
                .state(travelDevelopment.getState())
                .safetyRank(travelDevelopment.getSafetyRank())
                .build();
    }
}
