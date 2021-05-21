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
public class CarInsurance extends Insurance {

    private Long carPrice;
    private LocalDate carReleaseDate;
    private Long drivingDistance;

    @Builder
    public CarInsurance(String name, Long payment, int expirationDate, Long carPrice,
                        LocalDate carReleaseDate, Long drivingDistance) {
        super(name, payment, expirationDate);
        this.carPrice = carPrice;
        this.carReleaseDate = carReleaseDate;
        this.drivingDistance = drivingDistance;
    }

}
