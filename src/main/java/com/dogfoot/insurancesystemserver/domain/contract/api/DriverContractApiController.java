package com.dogfoot.insurancesystemserver.domain.contract.api;

import com.dogfoot.insurancesystemserver.domain.contract.domain.DriverContract;
import com.dogfoot.insurancesystemserver.domain.contract.dto.DriverContractCreateRequest;
import com.dogfoot.insurancesystemserver.domain.contract.dto.DriverContractResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.DriverInsurance;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("api/v1/user/contract/driver")
@RestController
public class DriverContractApiController extends
        ContractApiControllerImpl<DriverInsurance, DriverContractCreateRequest, DriverContractResponse, DriverContract> {
}
