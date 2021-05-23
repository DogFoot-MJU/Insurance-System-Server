package com.dogfoot.insurancesystemserver.domain.contract.domain;

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
public class CarContract extends Contract {

    private Long customerCarPrice;
    private LocalDate customerCarReleaseDate;
    private Long customerDrivingDistance;

    @Builder
    public CarContract(User user, Insurance<?> insurance, String customerPhysical, String customerEconomical,
                       String customerEnvironmental, Long calculatedPayment, LocalDate expirationDate,
                       Long customerCarPrice, LocalDate customerCarReleaseDate, Long customerDrivingDistance) {
        super(user, insurance, customerPhysical, customerEconomical, customerEnvironmental, calculatedPayment, expirationDate);
        this.customerCarPrice = customerCarPrice;
        this.customerCarReleaseDate = customerCarReleaseDate;
        this.customerDrivingDistance = customerDrivingDistance;
    }
}
