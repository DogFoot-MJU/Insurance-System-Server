package com.dogfoot.insurancesystemserver.domain.contract.api;

import com.dogfoot.insurancesystemserver.domain.contract.domain.CarContract;
import com.dogfoot.insurancesystemserver.domain.contract.dto.CarContractCreateRequest;
import com.dogfoot.insurancesystemserver.domain.contract.dto.CarContractResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.CarInsurance;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("api/v1/contract/car")
@RestController
public class CarContractApiController extends
        ContractApiControllerImpl<CarInsurance, CarContractCreateRequest, CarContractResponse, CarContract> {
}
