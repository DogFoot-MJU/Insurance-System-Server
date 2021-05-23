package com.dogfoot.insurancesystemserver.domain.insurance.service;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.TravelInsurance;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.TravelInsuranceDetailResponse;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TravelInsuranceService extends InsuranceServiceImpl<TravelInsuranceDetailResponse, TravelInsurance> {

    @Override
    public Specification<TravelInsurance> getAvailableSpecification() {
        return specification.equalToType("Travel").and(specification.equalToAvailable());
    }

    @Override
    public Specification<TravelInsurance> getUnAvailableSpecification() {
        return specification.equalToType("Travel").and(specification.equalToUnAvailable());
    }

}
