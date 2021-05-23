package com.dogfoot.insurancesystemserver.domain.insurance.api;

import com.dogfoot.insurancesystemserver.domain.insurance.dto.CarInsuranceDetailResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.InsuranceResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.service.CarInsuranceService;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/v1/user/car")
@RestController
public class CarInsuranceApiController implements InsuranceApiController<CarInsuranceDetailResponse>{

    private final CarInsuranceService insuranceService;

    @Override
    public ResponseEntity<Pagination<List<InsuranceResponse>>> listByAvailableSale(Pageable pageable) {
        return ResponseEntity.ok(this.insuranceService.listByAvailableSale(pageable));
    }

//    @GetMapping("user/car/insurance/unavailable/list")
//    public ResponseEntity<Pagination<List<CarInsuranceResponse>>> listByUnAvailableSale(@PageableDefault Pageable pageable) {
//            return ResponseEntity.ok(this.carInsuranceService.listByUnAvailableSale(pageable));
//    }

    @Override
    public ResponseEntity<CarInsuranceDetailResponse> detail(Long id) {
        return ResponseEntity.ok(this.insuranceService.read(id));
    }

}
