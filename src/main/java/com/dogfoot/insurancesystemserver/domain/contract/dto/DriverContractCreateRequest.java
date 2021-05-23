package com.dogfoot.insurancesystemserver.domain.contract.dto;

import com.dogfoot.insurancesystemserver.domain.contract.domain.DriverContract;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.DriverInsurance;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.DriverLicence;
import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DriverContractCreateRequest extends ContractCreateRequest<DriverContract, DriverInsurance> {

    @NotNull private Long insuranceId;
    @NotBlank private String customerPhysical;
    @NotBlank private String customerEconomical;
    @NotBlank private String customerEnvironmental;
    @NotNull private LocalDate dateOfLicenseAcquisition;
    @NotNull private DriverLicence driverLicence;

    @Override
    public DriverContract toEntity(User user, DriverInsurance driverInsurance, Long payment) {
        return DriverContract.builder()
                .user(user)
                .insurance(driverInsurance)
                .calculatedPayment(payment)
                .customerPhysical(this.customerPhysical)
                .customerEconomical(this.customerEconomical)
                .customerEnvironmental(this.customerEnvironmental)
                .dateOfLicenseAcquisition(this.dateOfLicenseAcquisition)
                .driverLicence(this.driverLicence)
                .build();
    }

}
