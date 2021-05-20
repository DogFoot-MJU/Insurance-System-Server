package com.dogfoot.insurancesystemserver.domain.productdevelopment.domain;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.FireInsurance;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.FireProductDesignRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class FireDevelopment extends ProductDevelopment {

    private Long buildingPrice;
    private LocalDate constructionDate;
    private Long siteArea;
    private Integer numberOfFloors;

    @Builder
    public FireDevelopment(String name, Long payment, Long buildingPrice, LocalDate constructionDate, Long siteArea, Integer numberOfFloors) {
        super(name, payment);
        this.buildingPrice = buildingPrice;
        this.constructionDate = constructionDate;
        this.siteArea = siteArea;
        this.numberOfFloors = numberOfFloors;
        changeState(DevelopmentState.PLAN);
        changeApproveSate(ApproveState.NONE);
    }

    public FireDevelopment design(FireProductDesignRequest dto) {
        this.buildingPrice = dto.getBuildingPrice();
        this.constructionDate = dto.getConstructionDate();
        this.siteArea = dto.getSiteArea();
        this.numberOfFloors = dto.getNumberOfFloors();
        changeState(DevelopmentState.DESIGN);
        return this;
    }

    public FireDevelopment authorize() {
        this.changeState(DevelopmentState.AUTHORIZE);
        return this;
    }

    public FireInsurance approve() {
        changeState(DevelopmentState.APPROVE);
        changeApproveSate(ApproveState.APPROVE);
        return FireInsurance.builder()
                .name(getName())
                .payment(getPayment())
                .buildingPrice(this.buildingPrice)
                .constructionDate(this.constructionDate)
                .siteArea(this.siteArea)
                .numberOfFloors(this.numberOfFloors)
                .build();
    }
}