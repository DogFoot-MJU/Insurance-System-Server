package com.dogfoot.insurancesystemserver.domain.contract.domain;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.DriverLicence;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
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
public class DriverContract extends Contract {

    private LocalDate dateOfLicenseAcquisition;
    private DriverLicence driverLicence;

    @Builder
    public DriverContract(User user, Insurance insurance, String customerPhysical, String customerEconomical,
                          String customerEnvironmental, Long calculatedPayment, LocalDate expirationDate,
                          LocalDate dateOfLicenseAcquisition, DriverLicence driverLicence) {
        super(user, insurance, customerPhysical, customerEconomical, customerEnvironmental, calculatedPayment, expirationDate);
        this.dateOfLicenseAcquisition = dateOfLicenseAcquisition;
        this.driverLicence = driverLicence;
    }

}
