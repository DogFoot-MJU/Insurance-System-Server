package com.dogfoot.insurancesystemserver.domain.insurance.api;

import com.dogfoot.insurancesystemserver.domain.insurance.dto.DriverInsuranceDetailResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.InsuranceResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.service.DriverInsuranceService;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/v1/user/driver")
@RestController
public class DriverInsuranceApiController implements InsuranceApiController<DriverInsuranceDetailResponse> {

    private final DriverInsuranceService insuranceService;

    @Override
    public ResponseEntity<Pagination<List<InsuranceResponse>>> listByAvailableSale(Pageable pageable) {
        return ResponseEntity.ok(this.insuranceService.listByAvailableSale(pageable));
    }

    @Override
    public ResponseEntity<DriverInsuranceDetailResponse> detail(Long id) {
        return ResponseEntity.ok(this.insuranceService.read(id));
    }
}
