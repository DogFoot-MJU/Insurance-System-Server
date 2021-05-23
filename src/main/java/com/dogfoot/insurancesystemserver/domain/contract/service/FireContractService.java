package com.dogfoot.insurancesystemserver.domain.contract.service;

import com.dogfoot.insurancesystemserver.domain.contract.domain.FireContract;
import com.dogfoot.insurancesystemserver.domain.contract.dto.FireContractCreateRequest;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.FireInsurance;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.FireInsuranceDetailResponse;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;

@Service
public class FireContractService extends ContractServiceImpl<FireContract, FireInsuranceDetailResponse, FireInsurance, FireContractCreateRequest> {

    @Override
    public Long calculatePayment(FireContractCreateRequest dto, FireInsurance fireInsurance) {
        float rate = 1;
        Long buildingPrice = fireInsurance.getBuildingPrice();
        int floors = dto.getNumberOfFloors();
        Long area = dto.getSiteArea();
        long day = Duration.between(dto.getConstructionDate().atStartOfDay(), LocalDate.now().atStartOfDay()).toDays();
        long criteriaDay = Duration.between(fireInsurance.getConstructionDate(), LocalDate.now().atStartOfDay()).toDays();
        if (buildingPrice < fireInsurance.getBuildingPrice() - 500000000) rate += 0.1;
        else if (buildingPrice < fireInsurance.getBuildingPrice()) rate += 0.2;
        else if (buildingPrice < fireInsurance.getBuildingPrice() + 50000000) rate += 0.3;
        else rate += 0.4;
        if (day < criteriaDay-730) rate += 0.1;
        else if (day < criteriaDay) rate += 0.2;
        else if (day < criteriaDay+730) rate += 0.3;
        else rate += 0.4;
        if (floors < fireInsurance.getNumberOfFloors() - 5) rate += 0.1;
        else if (floors < fireInsurance.getNumberOfFloors()) rate += 0.2;
        else if (floors < fireInsurance.getNumberOfFloors() + 5) rate += 0.3;
        else rate += 0.4;
        if (area < fireInsurance.getSiteArea() - 30) rate += 0.1;
        else if (area < fireInsurance.getNumberOfFloors()) rate += 0.2;
        else if (area < fireInsurance.getNumberOfFloors() + 30) rate += 0.3;
        else rate += 0.4;
        return (long) Math.round(fireInsurance.getPayment() * rate);
    }
}
