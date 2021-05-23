package com.dogfoot.insurancesystemserver.domain.insurance.api;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.InsuranceResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.service.InsuranceService;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class InsuranceApiControllerImpl<DetailReq, I extends Insurance> implements InsuranceApiController<DetailReq> {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private InsuranceService<DetailReq, I> insuranceService;

    @Override
    public ResponseEntity<Pagination<List<InsuranceResponse>>> listByAvailableSale(Pageable pageable) {
        return ResponseEntity.ok(this.insuranceService.listByAvailableSale(pageable));
    }

    @Override
    public ResponseEntity<DetailReq> detail(Long id) {
        return ResponseEntity.ok(this.insuranceService.read(id));
    }

}
