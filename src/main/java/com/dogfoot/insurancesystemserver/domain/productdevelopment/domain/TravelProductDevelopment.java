package com.dogfoot.insurancesystemserver.domain.productdevelopment.domain;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.SafetyRank;
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
    }
}
