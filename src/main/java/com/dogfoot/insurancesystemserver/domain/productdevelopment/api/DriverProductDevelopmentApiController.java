package com.dogfoot.insurancesystemserver.domain.productdevelopment.api;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.*;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.exception.DuplicateInsuranceNameException;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.service.DriverProductDevelopmentService;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/v1/planner/driver/product/development")
@RestController
public class DriverProductDevelopmentApiController {

    private final DriverProductDevelopmentService driverProductDevelopmentService;

    @PostMapping("plan")
    public ResponseEntity<ProductPlanDevelopmentResponse> plan(
            @Valid @RequestBody ProductPlanCreateRequest dto) throws DuplicateInsuranceNameException {
        return ResponseEntity.ok(driverProductDevelopmentService.plan(dto));
    }

    @PostMapping("design")
    public ResponseEntity<DriverProductDevelopmentDetailResponse> design(@Valid @RequestBody DriverProductDesignRequest dto) {
        return ResponseEntity.ok(driverProductDevelopmentService.design(dto));
    }

    @PostMapping("authorize/{id}")
    public ResponseEntity<DriverProductDevelopmentDetailResponse> authorize(@PathVariable Long id) {
        return ResponseEntity.ok(driverProductDevelopmentService.authorize(id));
    }

    @GetMapping("list")
    public ResponseEntity<Pagination<List<ProductPlanDevelopmentResponse>>> list(@PageableDefault Pageable pageable,
                                                                                 @RequestParam DevelopmentState state) {
        return ResponseEntity.ok(driverProductDevelopmentService.list(pageable, state));
    }

    @GetMapping("{id}")
    public ResponseEntity<DriverProductDevelopmentDetailResponse> read(@PathVariable Long id) {
        return ResponseEntity.ok(driverProductDevelopmentService.read(id));
    }

}
