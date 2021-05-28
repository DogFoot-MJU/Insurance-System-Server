package com.dogfoot.insurancesystemserver.domain.contract.domain;

import com.dogfoot.insurancesystemserver.domain.contract.dto.FireContractResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import com.dogfoot.insurancesystemserver.domain.user.domain.User;
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
public class FireContract extends Contract<FireContractResponse> {

    private Long buildingPrice;
    private LocalDate constructionDate;
    private Long siteArea;
    private Integer numberOfFloors;

    @Builder
    public FireContract(User user, Insurance insurance, String customerPhysical, String customerEconomical,
                        String customerEnvironmental, Long calculatedPayment, LocalDate expirationDate,
                        Long buildingPrice, LocalDate constructionDate, Long siteArea, Integer numberOfFloors) {
        super(user, insurance, customerPhysical, customerEconomical, customerEnvironmental, calculatedPayment, expirationDate);
        this.buildingPrice = buildingPrice;
        this.constructionDate = constructionDate;
        this.siteArea = siteArea;
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public FireContractResponse toResponse() {
        return FireContractResponse.builder()
                .userName(getUser().getName())
                .email(getUser().getEmail())
                .insuranceId(getInsurance().getId())
                .insuranceName(getInsurance().getName())
                .customerPhysical(getCustomerPhysical())
                .customerEconomical(getCustomerEconomical())
                .customerEnvironmental(getCustomerEnvironmental())
                .calculatedPayment(getCalculatedPayment())
                .expirationDate(getExpirationDate())
                .uwDueProcessType(getUwDueProcessType())
                .buildingPrice(this.buildingPrice)
                .constructionDate(this.constructionDate)
                .siteArea(this.siteArea)
                .numberOfFloors(this.numberOfFloors)
                .build();
    }
}
