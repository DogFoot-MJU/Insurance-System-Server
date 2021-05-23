package com.dogfoot.insurancesystemserver.domain.insurance.service;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.DriverInsurance;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.DriverInsuranceDetailResponse;
import com.dogfoot.insurancesystemserver.global.util.ListSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DriverInsuranceService extends InsuranceServiceImpl<DriverInsuranceDetailResponse, DriverInsurance> {

    private final ListSpecification<DriverInsurance> specification;

    @Override
    public Specification<DriverInsurance> getSpecification() {
        return specification.equalToType("Driver").and(specification.equalToIsAvailableTrue());
    }
}
