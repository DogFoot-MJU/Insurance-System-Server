package com.dogfoot.insurancesystemserver.domain.insurance.api;

import com.dogfoot.insurancesystemserver.domain.insurance.dto.InsuranceResponse;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface InsuranceApiController<DetailReq> {

    @GetMapping("insurance/available/list")
    ResponseEntity<Pagination<List<InsuranceResponse>>> listByAvailableSale(@PageableDefault Pageable pageable);

    @GetMapping("insurance/{id}")
    ResponseEntity<DetailReq> detail(@PathVariable Long id);

}
