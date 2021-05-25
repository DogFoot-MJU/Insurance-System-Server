package com.dogfoot.insurancesystemserver.domain.contract.api.uw;

import com.dogfoot.insurancesystemserver.domain.contract.domain.FireContract;
import com.dogfoot.insurancesystemserver.domain.contract.dto.FireContractResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.FireInsurance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/uw/contract/fire")
@RestController
public class UwFireContractController extends UwContractControllerImpl<FireInsurance, FireContractResponse, FireContract> {
}
