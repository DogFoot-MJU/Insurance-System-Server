package com.dogfoot.insurancesystemserver.domain.contract.api.uw;

import com.dogfoot.insurancesystemserver.domain.contract.domain.DriverContract;
import com.dogfoot.insurancesystemserver.domain.contract.dto.DriverContractResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.DriverInsurance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/uw/contract/driver")
@RestController
public class UwDriverContractController extends UwContractControllerImpl<DriverInsurance, DriverContractResponse, DriverContract> {
}
