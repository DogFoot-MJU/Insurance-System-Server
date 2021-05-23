package com.dogfoot.insurancesystemserver.domain.insurance.domain;


import com.dogfoot.insurancesystemserver.domain.insurance.dto.TravelInsuranceDetailResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("Travel")
@Entity
public class TravelInsurance extends Insurance<TravelInsuranceDetailResponse> {

    private SafetyRank safetyRank;

    @Builder
    public TravelInsurance(String name, Long payment, int expirationDate, SafetyRank safetyRank) {
        super(name, payment, expirationDate);
        this.safetyRank = safetyRank;
    }

    @Override
    public TravelInsuranceDetailResponse toDetailResponse() {
        return null;
    }
}
