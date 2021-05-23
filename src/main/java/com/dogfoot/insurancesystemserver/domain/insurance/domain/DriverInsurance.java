package com.dogfoot.insurancesystemserver.domain.insurance.domain;

import com.dogfoot.insurancesystemserver.domain.insurance.dto.DriverInsuranceDetailResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("Driver")
@Entity
public class DriverInsurance extends Insurance<DriverInsuranceDetailResponse> {

    private LocalDate dateOfLicenseAcquisition;
    private DriverLicence driverLicence;

    @Builder
    public DriverInsurance(String name, Long payment, int expirationDate,
                           LocalDate dateOfLicenseAcquisition, DriverLicence driverLicence) {
        super(name, payment, expirationDate);
        this.dateOfLicenseAcquisition = dateOfLicenseAcquisition;
        this.driverLicence = driverLicence;
    }

    @Override
    public DriverInsuranceDetailResponse toDetailResponse() {
        return DriverInsuranceDetailResponse.builder()
                .id(this.getId())
                .name(this.getName())
                .payment(this.getPayment())
                .physical(this.getCapacityPolicy().getPhysical())
                .economical(this.getCapacityPolicy().getEconomical())
                .environmental(this.getCapacityPolicy().getEnvironmental())
                .isAvailableSale(this.isAvailableSale())
                .dateOfLicenseAcquisition(this.dateOfLicenseAcquisition)
                .driverLicence(this.driverLicence)
                .build();
    }
}
