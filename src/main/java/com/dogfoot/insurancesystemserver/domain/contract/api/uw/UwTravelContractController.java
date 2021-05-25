package com.dogfoot.insurancesystemserver.domain.contract.api.uw;

import com.dogfoot.insurancesystemserver.domain.contract.domain.TravelContract;
import com.dogfoot.insurancesystemserver.domain.contract.dto.TravelContractResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.TravelInsurance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/uw/contract/travel")
@RestController
public class UwTravelContractController extends UwContractControllerImpl<TravelInsurance, TravelContractResponse, TravelContract> {
}
