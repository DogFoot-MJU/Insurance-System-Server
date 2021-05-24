package com.dogfoot.insurancesystemserver.domain.contract.api;

import com.dogfoot.insurancesystemserver.domain.contract.domain.TravelContract;
import com.dogfoot.insurancesystemserver.domain.contract.dto.TravelContractCreateRequest;
import com.dogfoot.insurancesystemserver.domain.contract.dto.TravelContractResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.TravelInsurance;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("api/v1/contract/travel")
@RestController
public class TravelContractApiController extends
        ContractApiControllerImpl<TravelInsurance, TravelContractCreateRequest, TravelContractResponse, TravelContract> {
}
