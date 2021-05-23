package com.dogfoot.insurancesystemserver.domain.contract.dto;

import com.dogfoot.insurancesystemserver.domain.contract.domain.CarContract;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.CarInsurance;
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
public class CarContractCreateCreateRequest extends ContractCreateRequest<CarContract, CarInsurance> {

    @NotNull private Long insuranceId;
    @NotBlank private String customerPhysical;
    @NotBlank private String customerEconomical;
    @NotBlank private String customerEnvironmental;
    @NotNull private Long customerCarPrice;
    @NotNull private LocalDate customerCarReleaseDate;
    @NotNull private Long customerDrivingDistance;

    @Override
    public CarContract toEntity(User user, CarInsurance carInsurance, Long payment) {
        return CarContract.builder()
                .user(user)
                .insurance(carInsurance)
                .calculatedPayment(payment)
                .customerPhysical(this.customerPhysical)
                .customerEconomical(this.customerEconomical)
                .customerEnvironmental(this.customerEnvironmental)
                .customerCarPrice(this.customerCarPrice)
                .customerCarReleaseDate(this.customerCarReleaseDate)
                .customerDrivingDistance(this.customerDrivingDistance)
                .build();
    }
}
