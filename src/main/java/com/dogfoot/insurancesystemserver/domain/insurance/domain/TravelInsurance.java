package com.dogfoot.insurancesystemserver.domain.insurance.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class TravelInsurance extends Insurance {

    private SafetyRank safetyRank;

    @Builder
    public TravelInsurance(String name, Long payment, int expirationDate, SafetyRank safetyRank) {
        super(name, payment, expirationDate);
        this.safetyRank = safetyRank;
    }

}
