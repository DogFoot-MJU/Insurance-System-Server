package com.dogfoot.insurancesystemserver.domain.insurance.service;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.CarInsurance;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.CarInsuranceDetailResponse;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CarInsuranceService extends InsuranceServiceImpl<CarInsuranceDetailResponse, CarInsurance> {

    @Override
    public Specification<CarInsurance> getAvailableSpecification() {
        return specification.equalToType("Car").and(specification.equalToAvailable());
    }

    @Override
    public Specification<CarInsurance> getUnAvailableSpecification() {
        return specification.equalToType("Car").and(specification.equalToUnAvailable());
    }

}
