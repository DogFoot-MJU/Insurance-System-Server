package com.dogfoot.insurancesystemserver.domain.insurance.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class TravelInsurance extends Insurance {

    private SafetyRank safetyRank;

    @Builder
    public TravelInsurance(String name, Long payment, SafetyRank safetyRank) {
        super(name, payment);
        this.safetyRank = safetyRank;
    }

}
