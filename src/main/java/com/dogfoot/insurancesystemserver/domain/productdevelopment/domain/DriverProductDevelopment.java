package com.dogfoot.insurancesystemserver.domain.productdevelopment.domain;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.DriverLicence;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.DriverProductDesignRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class DriverProductDevelopment extends ProductDevelopment {

    private LocalDate DateOfLicenseAcquisition;
    private DriverLicence driverLicence;

    @Builder
    public DriverProductDevelopment(String name, Long payment, LocalDate dateOfLicenseAcquisition, DriverLicence driverLicence) {
        super(name, payment);
        DateOfLicenseAcquisition = dateOfLicenseAcquisition;
        this.driverLicence = driverLicence;
    }

    public DriverProductDevelopment design(DriverProductDesignRequest dto) {
        this.DateOfLicenseAcquisition = dto.getDateOfLicenseAcquisition();
        this.driverLicence = dto.getDriverLicence();
        return this;
    }

    public DriverProductDevelopment authorize() {
        this.changeState(DevelopmentState.AUTHORIZE);
        return this;
    }
}
