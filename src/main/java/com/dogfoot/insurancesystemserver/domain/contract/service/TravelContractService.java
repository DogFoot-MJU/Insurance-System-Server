package com.dogfoot.insurancesystemserver.domain.contract.service;

import com.dogfoot.insurancesystemserver.domain.contract.domain.TravelContract;
import com.dogfoot.insurancesystemserver.domain.contract.dto.TravelContractCreateRequest;
import com.dogfoot.insurancesystemserver.domain.contract.dto.TravelContractResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.SafetyRank;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.TravelInsurance;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.TravelInsuranceDetailResponse;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TravelContractService extends
        ContractServiceImpl<TravelContract, TravelInsuranceDetailResponse, TravelInsurance,
                TravelContractCreateRequest, TravelContractResponse> {

    @Override
    public Long calculatePayment(TravelContractCreateRequest dto, TravelInsurance travelInsurance) {
        float rate = 1;
        SafetyRank safetyRank = dto.getSafetyRank();
        if(safetyRank.equals(SafetyRank.GREEN)) rate += 0.1;
        else if(safetyRank.equals(SafetyRank.BLUE)) rate += 0.2;
        else if(safetyRank.equals(SafetyRank.RED)) rate += 0.3;
        else rate += 0.4;
        return (long) Math.round(travelInsurance.getPayment() * rate);
    }

    @Override
    public Specification<TravelContract> getUwDueProcessNoneSpecification() {
        return Specification.where(specification.equalToType("Travel").and(specification.equalUwDueProcessWait()));
    }
}
