package com.dogfoot.insurancesystemserver.domain.contract.service;

import com.dogfoot.insurancesystemserver.domain.contract.domain.TravelContract;
import com.dogfoot.insurancesystemserver.domain.contract.dto.TravelContractCreateRequest;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.TravelInsurance;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.TravelInsuranceDetailResponse;
import org.springframework.stereotype.Service;

@Service
public class TravelContractService extends ContractServiceImpl<TravelContract, TravelInsuranceDetailResponse, TravelInsurance, TravelContractCreateRequest> {

    @Override
    public Long calculatePayment(TravelContractCreateRequest dto, TravelInsurance entity) {
        return 1L;
    }
}
