package com.dogfoot.insurancesystemserver.domain.insurance.service;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.DriverInsurance;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.DriverInsuranceDetailResponse;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class DriverInsuranceService extends InsuranceServiceImpl<DriverInsuranceDetailResponse, DriverInsurance> {

    @Override
    public Specification<DriverInsurance> getAvailableSpecification() {
        return specification.equalToType("Driver").and(specification.equalToAvailable());
    }

    @Override
    public Specification<DriverInsurance> getUnAvailableSpecification() {
        return specification.equalToType("Driver").and(specification.equalToUnAvailable());
    }

}
