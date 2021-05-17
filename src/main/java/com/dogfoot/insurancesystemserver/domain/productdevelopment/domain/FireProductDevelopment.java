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
public class FireProductDevelopment extends ProductDevelopment {

    private Long buildingPrice;
    private LocalDate constructionDate;
    private Long siteArea;
    private Integer numberOfFloors;

    @Builder
    public FireProductDevelopment(String name, Long payment, Long buildingPrice, LocalDate constructionDate, Long siteArea, Integer numberOfFloors) {
        super(name, payment);
        this.buildingPrice = buildingPrice;
        this.constructionDate = constructionDate;
        this.siteArea = siteArea;
        this.numberOfFloors = numberOfFloors;
    }
}
