package com.dogfoot.insurancesystemserver.domain.insurance.service;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.FireInsurance;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.FireInsuranceDetailResponse;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class FireInsuranceService extends InsuranceServiceImpl<FireInsuranceDetailResponse, FireInsurance> {
    @Override
    public Specification<FireInsurance> getAvailableSpecification() {
        return specification.equalToType("Fire").and(specification.equalToAvailable());
    }

    @Override
    public Specification<FireInsurance> getUnAvailableSpecification() {
        return specification.equalToType("Fire").and(specification.equalToUnAvailable());
    }

}
