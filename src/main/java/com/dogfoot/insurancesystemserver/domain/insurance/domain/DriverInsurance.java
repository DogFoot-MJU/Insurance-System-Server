package com.dogfoot.insurancesystemserver.domain.insurance.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class DriverInsurance extends Insurance {

    private LocalDate DateOfLicenseAcquisition;
    private DriverLicence driverLicence;

    @Builder
    public DriverInsurance(String name, Long payment, LocalDate dateOfLicenseAcquisition, DriverLicence driverLicence) {
        super(name, payment);
        DateOfLicenseAcquisition = dateOfLicenseAcquisition;
        this.driverLicence = driverLicence;
    }

}
