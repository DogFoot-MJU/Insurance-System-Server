package com.dogfoot.insurancesystemserver.domain.productdevelopment.domain;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.CarInsurance;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.CarProductDesignRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@SuppressWarnings("JpaObjectClassSignatureInspection")
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
        changeState(DevelopmentState.PLAN);
        changeApproveSate(ApproveState.NONE);
    }

    public CarProductDevelopment design(CarProductDesignRequest dto) {
        this.carPrice = dto.getCarPrice();
        this.carReleaseDate = dto.getCarReleaseDate();
        this.drivingDistance = dto.getDrivingDistance();
        changeState(DevelopmentState.DESIGN);
        return this;
    }

    public CarProductDevelopment authorize() {
        changeState(DevelopmentState.AUTHORIZE);
        changeApproveSate(ApproveState.WAIT);
        return this;
    }

    public CarInsurance approve() {
        changeState(DevelopmentState.APPROVE);
        changeApproveSate(ApproveState.APPROVE);
        return CarInsurance.builder()
                .name(getName())
                .payment(getPayment())
                .carPrice(this.carPrice)
                .carReleaseDate(this.carReleaseDate)
                .drivingDistance(this.drivingDistance)
                .build();
    }

}
