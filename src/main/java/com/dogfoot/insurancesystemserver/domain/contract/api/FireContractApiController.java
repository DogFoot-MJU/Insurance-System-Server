package com.dogfoot.insurancesystemserver.domain.contract.api;

import com.dogfoot.insurancesystemserver.domain.contract.domain.FireContract;
import com.dogfoot.insurancesystemserver.domain.contract.dto.FireContractCreateRequest;
import com.dogfoot.insurancesystemserver.domain.contract.dto.FireContractResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.FireInsurance;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("api/v1/contract/fire")
@RestController
public class FireContractApiController extends
        ContractApiControllerImpl<FireInsurance, FireContractCreateRequest, FireContractResponse, FireContract> {
}
