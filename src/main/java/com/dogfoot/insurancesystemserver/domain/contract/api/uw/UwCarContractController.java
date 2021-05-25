package com.dogfoot.insurancesystemserver.domain.contract.api.uw;

import com.dogfoot.insurancesystemserver.domain.contract.domain.CarContract;
import com.dogfoot.insurancesystemserver.domain.contract.dto.CarContractResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.CarInsurance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/uw/contract/car")
@RestController
public class UwCarContractController extends UwContractControllerImpl<CarInsurance, CarContractResponse, CarContract> {
}
