package com.dogfoot.insurancesystemserver.domain.contract.service;

import com.dogfoot.insurancesystemserver.domain.contract.domain.DriverContract;
import com.dogfoot.insurancesystemserver.domain.contract.dto.DriverContractCreateRequest;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.DriverInsurance;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.DriverInsuranceDetailResponse;
import org.springframework.stereotype.Service;

@Service
public class DriverContractService extends ContractServiceImpl<DriverContract, DriverInsuranceDetailResponse, DriverInsurance, DriverContractCreateRequest> {

    @Override
    public Long calculatePayment(DriverContractCreateRequest dto, DriverInsurance entity) {
        return 1L;
    }
}
