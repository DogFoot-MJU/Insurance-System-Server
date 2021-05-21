package com.dogfoot.insurancesystemserver.domain.insurance.api;

import com.dogfoot.insurancesystemserver.domain.insurance.dto.CarInsuranceDetailResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.InsuranceResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.service.CarInsuranceServiceImpl;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/v1")
@RestController
public class CarInsuranceApiController {

    private final CarInsuranceServiceImpl carInsuranceService;

    @GetMapping("user/car/insurance/available/list")
    public ResponseEntity<Pagination<List<InsuranceResponse>>> listByAvailableSale(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(this.carInsuranceService.listByAvailableSale(pageable));
    }

//    @GetMapping("user/car/insurance/unavailable/list")
//    public ResponseEntity<Pagination<List<CarInsuranceResponse>>> listByUnAvailableSale(@PageableDefault Pageable pageable) {
//            return ResponseEntity.ok(this.carInsuranceService.listByUnAvailableSale(pageable));
//    }

    @GetMapping("user/car/insurance/{id}")
    public ResponseEntity<CarInsuranceDetailResponse> detail(@PathVariable Long id) {
        return ResponseEntity.ok(this.carInsuranceService.read(id));
    }

}
