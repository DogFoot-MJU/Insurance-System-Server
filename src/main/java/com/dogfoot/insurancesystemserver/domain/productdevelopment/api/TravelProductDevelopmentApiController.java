package com.dogfoot.insurancesystemserver.domain.productdevelopment.api;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.*;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.exception.DuplicateInsuranceNameException;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.service.TravelProductDevelopmentService;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/v1/planner/travel/product/development")
@RestController
public class TravelProductDevelopmentApiController {

    private final TravelProductDevelopmentService travelProductDevelopmentService;

    @PostMapping("plan")
    public ResponseEntity<ProductPlanDevelopmentResponse> plan(
            @Valid @RequestBody ProductPlanCreateRequest dto) throws DuplicateInsuranceNameException {
        return ResponseEntity.ok(travelProductDevelopmentService.plan(dto));
    }

    @PutMapping("design")
    public ResponseEntity<TravelProductDevelopmentDetailResponse> design(@Valid @RequestBody TravelProductDesignRequest dto) {
        return ResponseEntity.ok(travelProductDevelopmentService.design(dto));
    }

    @PutMapping("authorize/{id}")
    public ResponseEntity<TravelProductDevelopmentDetailResponse> authorize(@PathVariable Long id) {
        return ResponseEntity.ok(travelProductDevelopmentService.authorize(id));
    }

    @GetMapping("list")
    public ResponseEntity<Pagination<List<ProductPlanDevelopmentResponse>>> list(@PageableDefault Pageable pageable,
                                                                                 @RequestParam DevelopmentState state) {
        return ResponseEntity.ok(travelProductDevelopmentService.list(pageable, state));
    }

    @GetMapping("{id}")
    public ResponseEntity<TravelProductDevelopmentDetailResponse> read(@PathVariable Long id) {
        return ResponseEntity.ok(travelProductDevelopmentService.read(id));
    }

}
