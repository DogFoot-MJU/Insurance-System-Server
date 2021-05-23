package com.dogfoot.insurancesystemserver.domain.productdevelopment.domain;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.SafetyRank;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.TravelInsurance;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.ProductPlanDevelopmentResponse;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.TravelProductDesignRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("Travel")
@Entity
public class TravelDevelopment extends ProductDevelopment {

    @Enumerated(EnumType.STRING)
    private SafetyRank safetyRank;

    @Builder
    public TravelDevelopment(String name, Long payment, int expirationDate, SafetyRank safetyRank) {
        super(name, payment, expirationDate);
        this.safetyRank = safetyRank;
        changeState(DevelopmentState.PLAN);
        changeApproveSate(ApproveState.NONE);
    }

    public TravelDevelopment design(TravelProductDesignRequest dto) {
        this.safetyRank = dto.getSafetyRank();
        changeState(DevelopmentState.DESIGN);
        return this;
    }

    public TravelDevelopment authorize() {
        changeState(DevelopmentState.AUTHORIZE);
        return this;
    }

    public TravelInsurance approve() {
        changeState(DevelopmentState.APPROVE);
        changeApproveSate(ApproveState.APPROVE);
        return TravelInsurance.builder()
                .name(getName())
                .payment(getPayment())
                .safetyRank(this.safetyRank)
                .build();
    }

    @Override
    public ProductPlanDevelopmentResponse toResponse() {
        return ProductPlanDevelopmentResponse.builder()
                .id(this.getId())
                .name(this.getName())
                .payment(this.getPayment())
                .state(this.getState())
                .build();
    }

}
