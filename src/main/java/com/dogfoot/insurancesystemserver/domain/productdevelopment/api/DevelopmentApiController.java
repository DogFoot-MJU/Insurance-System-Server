package com.dogfoot.insurancesystemserver.domain.productdevelopment.api;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.ProductPlanCreateRequest;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.ProductPlanDevelopmentResponse;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import com.dogfoot.insurancesystemserver.global.dto.PaginationDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface DevelopmentApiController<DesignReq, DetailRes> {

    @PostMapping("plan")
    ResponseEntity<DefaultResponseDto> plan(@Valid @RequestBody ProductPlanCreateRequest dto);


    @PutMapping("design")
    ResponseEntity<DefaultResponseDto> design(@Valid @RequestBody DesignReq dto);

    @PutMapping("authorize/{id}")
    ResponseEntity<DefaultResponseDto> authorize(@PathVariable Long id);

    @GetMapping("list")
    ResponseEntity<PaginationDto<List<ProductPlanDevelopmentResponse>>> list(@PageableDefault Pageable pageable, @RequestParam DevelopmentState state);

    @GetMapping("{id}")
    ResponseEntity<DetailRes> read(@PathVariable Long id);

    @DeleteMapping("{id}")
    ResponseEntity<DefaultResponseDto> delete(@PathVariable Long id);

}
