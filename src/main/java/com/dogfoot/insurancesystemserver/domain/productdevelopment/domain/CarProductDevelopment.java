package com.dogfoot.insurancesystemserver.domain.productdevelopment.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class CarProductDevelopment extends ProductDevelopment {

    private Long carPrice;
    private LocalDate carReleaseDate;
    private Long drivingDistance;

    @Builder
    public CarProductDevelopment(String name, Long payment, Long carPrice, LocalDate carReleaseDate, Long drivingDistance) {
        super(name, payment);
        this.carPrice = carPrice;
        this.carReleaseDate = carReleaseDate;
        this.drivingDistance = drivingDistance;
    }

}
