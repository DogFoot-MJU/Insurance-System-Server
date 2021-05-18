package com.dogfoot.insurancesystemserver.domain.productdevelopment.api;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.CarProductDesignRequest;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.CarProductDevelopmentDetailResponse;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.ProductPlanCreateRequest;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.ProductPlanDevelopmentResponse;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.exception.DuplicateInsuranceNameException;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.service.CarProductDevelopmentService;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/v1/planner/car/product/development")
@RestController
public class CarProductDevelopmentApiController {

    private final CarProductDevelopmentService carProductDevelopmentService;

    @PostMapping("plan")
    public ResponseEntity<ProductPlanDevelopmentResponse> plan(
            @Valid @RequestBody ProductPlanCreateRequest dto) throws DuplicateInsuranceNameException {
        return ResponseEntity.ok(carProductDevelopmentService.plan(dto));
    }

    @PostMapping("design")
    public ResponseEntity<CarProductDevelopmentDetailResponse> design(@Valid @RequestBody CarProductDesignRequest dto) {
        return ResponseEntity.ok(carProductDevelopmentService.design(dto));
    }

    @PostMapping("authorize/{id}")
    public ResponseEntity<CarProductDevelopmentDetailResponse> authorize(@PathVariable Long id) {
        return ResponseEntity.ok(carProductDevelopmentService.authorize(id));
    }

    @GetMapping("list")
    public ResponseEntity<Pagination<List<ProductPlanDevelopmentResponse>>> list(@PageableDefault Pageable pageable,
                                                                                 @RequestParam DevelopmentState state) {
        return ResponseEntity.ok(carProductDevelopmentService.list(pageable, state));
    }

    @GetMapping("{id}")
    public ResponseEntity<CarProductDevelopmentDetailResponse> read(@PathVariable Long id) {
        return ResponseEntity.ok(carProductDevelopmentService.read(id));
    }

}
