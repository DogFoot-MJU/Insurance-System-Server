package com.dogfoot.insurancesystemserver.domain.insurance.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class DriverInsurance extends Insurance {

    private LocalDate DateOfLicenseAcquisition;
    private DriverLicence driverLicence;

    @Builder
    public DriverInsurance(String name, Long payment, int expirationDate,
                           LocalDate dateOfLicenseAcquisition, DriverLicence driverLicence) {
        super(name, payment, expirationDate);
        DateOfLicenseAcquisition = dateOfLicenseAcquisition;
        this.driverLicence = driverLicence;
    }

}
