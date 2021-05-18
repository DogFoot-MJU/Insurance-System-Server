package com.dogfoot.insurancesystemserver.domain.productdevelopment.api;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.*;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.exception.DuplicateInsuranceNameException;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.service.FireProductDevelopmentService;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/v1/planner/fire/product/development")
@RestController
public class FireProductDevelopmentApiController {

    private final FireProductDevelopmentService fireProductDevelopmentService;

    @PostMapping("plan")
    public ResponseEntity<ProductPlanDevelopmentResponse> plan(
            @Valid @RequestBody ProductPlanCreateRequest dto) throws DuplicateInsuranceNameException {
        return ResponseEntity.ok(fireProductDevelopmentService.plan(dto));
    }

    @PostMapping("design")
    public ResponseEntity<FireProductDevelopmentDetailResponse> design(@Valid @RequestBody FireProductDesignRequest dto) {
        return ResponseEntity.ok(fireProductDevelopmentService.design(dto));
    }

    @PostMapping("authorize/{id}")
    public ResponseEntity<FireProductDevelopmentDetailResponse> authorize(@PathVariable Long id) {
        return ResponseEntity.ok(fireProductDevelopmentService.authorize(id));
    }

    @GetMapping("list")
    public ResponseEntity<Pagination<List<ProductPlanDevelopmentResponse>>> list(@PageableDefault Pageable pageable,
                                                                                 @RequestParam DevelopmentState state) {
        return ResponseEntity.ok(fireProductDevelopmentService.list(pageable, state));
    }

    @GetMapping("{id}")
    public ResponseEntity<FireProductDevelopmentDetailResponse> read(@PathVariable Long id) {
        return ResponseEntity.ok(fireProductDevelopmentService.read(id));
    }

}
