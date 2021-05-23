package com.dogfoot.insurancesystemserver.domain.contract.service;

import com.dogfoot.insurancesystemserver.domain.contract.domain.FireContract;
import com.dogfoot.insurancesystemserver.domain.contract.dto.FireContractCreateRequest;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.FireInsurance;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.FireInsuranceDetailResponse;
import org.springframework.stereotype.Service;

@Service
public class FireContractService extends ContractServiceImpl<FireContract, FireInsuranceDetailResponse, FireInsurance, FireContractCreateRequest> {

    @Override
    public Long calculatePayment(FireContractCreateRequest dto, FireInsurance entity) {
        return 1L;
    }
}
