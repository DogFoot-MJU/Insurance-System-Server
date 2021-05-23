package com.dogfoot.insurancesystemserver.domain.contract.dto;

import com.dogfoot.insurancesystemserver.domain.contract.domain.TravelContract;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.SafetyRank;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.TravelInsurance;
import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TravelContractCreateRequest extends ContractCreateRequest<TravelContract, TravelInsurance> {

    @NotNull private Long insuranceId;
    @NotBlank private String customerPhysical;
    @NotBlank private String customerEconomical;
    @NotBlank private String customerEnvironmental;
    @NotNull private SafetyRank safetyRank;


    @Override
    public TravelContract toEntity(User user, TravelInsurance travelInsurance, Long payment) {
        return TravelContract.builder()
                .user(user)
                .insurance(travelInsurance)
                .calculatedPayment(payment)
                .customerPhysical(this.customerPhysical)
                .customerEconomical(this.customerEconomical)
                .customerEnvironmental(this.customerEnvironmental)
                .safetyRank(this.safetyRank)
                .build();
    }
}
