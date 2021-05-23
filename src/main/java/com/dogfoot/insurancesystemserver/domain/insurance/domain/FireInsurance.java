package com.dogfoot.insurancesystemserver.domain.insurance.domain;

import com.dogfoot.insurancesystemserver.domain.insurance.dto.FireInsuranceDetailResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("Fire")
@Entity
public class FireInsurance extends Insurance<FireInsuranceDetailResponse> {

    private Long buildingPrice;
    private LocalDate constructionDate;
    private Long siteArea;
    private Integer numberOfFloors;

    @Builder
    public FireInsurance(String name, Long payment, int expirationDate, Long buildingPrice,
                         LocalDate constructionDate, Long siteArea, Integer numberOfFloors) {
        super(name, payment, expirationDate);
        this.buildingPrice = buildingPrice;
        this.constructionDate = constructionDate;
        this.siteArea = siteArea;
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public FireInsuranceDetailResponse toDetailResponse() {
        return null;
    }
}
