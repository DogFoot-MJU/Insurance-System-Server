package com.dogfoot.insurancesystemserver.domain.contract.service;

import com.dogfoot.insurancesystemserver.domain.contract.domain.TravelContract;
import com.dogfoot.insurancesystemserver.domain.contract.dto.TravelContractCreateRequest;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.SafetyRank;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.TravelInsurance;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.TravelInsuranceDetailResponse;
import org.springframework.stereotype.Service;

@Service
public class TravelContractService extends ContractServiceImpl<TravelContract, TravelInsuranceDetailResponse, TravelInsurance, TravelContractCreateRequest> {

    @Override
    public Long calculatePayment(TravelContractCreateRequest dto, TravelInsurance travelInsurance) {
        float rate = 1;
        SafetyRank safetyRank = dto.getSafetyRank();
        if(safetyRank.equals(SafetyRank.GREEN)) rate += 0.1;
        else if(safetyRank.equals(SafetyRank.BLUE)) rate += 0.2;
        else if(safetyRank.equals(SafetyRank.RED)) rate += 0.3;
        return (long) Math.round(travelInsurance.getPayment() * rate);
    }
}
