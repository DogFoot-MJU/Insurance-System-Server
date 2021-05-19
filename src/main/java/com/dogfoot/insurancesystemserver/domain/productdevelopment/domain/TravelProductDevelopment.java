package com.dogfoot.insurancesystemserver.domain.productdevelopment.domain;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.SafetyRank;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.TravelInsurance;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.TravelProductDesignRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class TravelProductDevelopment extends ProductDevelopment {

    private SafetyRank safetyRank;

    @Builder
    public TravelProductDevelopment(String name, Long payment, SafetyRank safetyRank) {
        super(name, payment);
        this.safetyRank = safetyRank;
        changeState(DevelopmentState.PLAN);
        changeApproveSate(ApproveState.NONE);
    }

    public TravelProductDevelopment design(TravelProductDesignRequest dto) {
        this.safetyRank = dto.getSafetyRank();
        changeState(DevelopmentState.DESIGN);
        return this;
    }

    public TravelProductDevelopment authorize() {
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
}
