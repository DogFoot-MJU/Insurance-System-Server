package com.dogfoot.insurancesystemserver.domain.insurance.api;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.CarInsurance;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.CarInsuranceDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("api/v1/user/car")
@RestController
public class CarInsuranceApiController extends InsuranceApiControllerImpl<CarInsuranceDetailResponse, CarInsurance> {

//    @GetMapping("user/car/insurance/unavailable/list")
//    public ResponseEntity<Pagination<List<CarInsuranceResponse>>> listByUnAvailableSale(@PageableDefault Pageable pageable) {
//            return ResponseEntity.ok(this.carInsuranceService.listByUnAvailableSale(pageable));
//    }

}
