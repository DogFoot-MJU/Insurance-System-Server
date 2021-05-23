package com.dogfoot.insurancesystemserver.domain.contract.domain;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.SafetyRank;
import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class TravelContract extends Contract {

    private SafetyRank safetyRank;

    @Builder
    public TravelContract(User user, Insurance insurance, String customerPhysical, String customerEconomical,
                          String customerEnvironmental, Long calculatedPayment, LocalDate expirationDate, SafetyRank safetyRank) {
        super(user, insurance, customerPhysical, customerEconomical, customerEnvironmental, calculatedPayment, expirationDate);
        this.safetyRank = safetyRank;
    }

}
