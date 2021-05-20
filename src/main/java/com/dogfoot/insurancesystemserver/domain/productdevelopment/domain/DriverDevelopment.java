package com.dogfoot.insurancesystemserver.domain.productdevelopment.domain;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.DriverInsurance;
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
public class DriverDevelopment extends ProductDevelopment {

    private LocalDate dateOfLicenseAcquisition;
    private DriverLicence driverLicence;

    @Builder
    public DriverDevelopment(String name, Long payment, LocalDate dateOfLicenseAcquisition, DriverLicence driverLicence) {
        super(name, payment);
        this.dateOfLicenseAcquisition = dateOfLicenseAcquisition;
        this.driverLicence = driverLicence;
        changeState(DevelopmentState.PLAN);
        changeApproveSate(ApproveState.NONE);
    }

    public DriverDevelopment design(DriverProductDesignRequest dto) {
        this.dateOfLicenseAcquisition = dto.getDateOfLicenseAcquisition();
        this.driverLicence = dto.getDriverLicence();
        changeState(DevelopmentState.DESIGN);
        return this;
    }

    public DriverDevelopment authorize() {
        changeState(DevelopmentState.AUTHORIZE);
        return this;
    }

    public DriverInsurance approve() {
        changeState(DevelopmentState.APPROVE);
        changeApproveSate(ApproveState.APPROVE);
        return DriverInsurance.builder()
                .name(getName())
                .payment(getPayment())
                .dateOfLicenseAcquisition(this.dateOfLicenseAcquisition)
                .driverLicence(this.driverLicence)
                .build();
    }
}
