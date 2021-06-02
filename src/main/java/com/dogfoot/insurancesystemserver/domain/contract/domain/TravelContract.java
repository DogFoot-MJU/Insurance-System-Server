package com.dogfoot.insurancesystemserver.domain.contract.domain;

import com.dogfoot.insurancesystemserver.domain.contract.dto.TravelContractResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.SafetyRank;
import com.dogfoot.insurancesystemserver.domain.user.domain.User;
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
public class TravelContract extends Contract<TravelContractResponse> {

    private SafetyRank safetyRank;

    @Builder
    public TravelContract(User user, Insurance insurance, String customerPhysical, String customerEconomical,
                          String customerEnvironmental, Long calculatedPayment, SafetyRank safetyRank) {
        super(user, insurance, customerPhysical, customerEconomical, customerEnvironmental, calculatedPayment);
        this.safetyRank = safetyRank;
    }

    @Override
    public TravelContractResponse toResponse() {
        return TravelContractResponse.builder()
                .id(getId())
                .userName(getUser().getName())
                .email(getUser().getEmail())
                .insuranceId(getInsurance().getId())
                .insuranceName(getInsurance().getName())
                .customerPhysical(getCustomerPhysical())
                .customerEconomical(getCustomerEconomical())
                .customerEnvironmental(getCustomerEnvironmental())
                .calculatedPayment(getCalculatedPayment())
                .expirationDate(getExpirationDate())
                .uwDueProcessType(getUwDueProcessType())
                .safetyRank(this.getSafetyRank())
                .build();
    }
}
