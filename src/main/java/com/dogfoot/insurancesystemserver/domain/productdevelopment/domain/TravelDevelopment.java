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
public class TravelDevelopment extends ProductDevelopment {

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
}
