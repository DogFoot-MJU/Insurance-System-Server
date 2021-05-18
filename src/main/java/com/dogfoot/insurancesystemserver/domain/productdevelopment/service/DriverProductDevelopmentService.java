package com.dogfoot.insurancesystemserver.domain.productdevelopment.service;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.*;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.exception.DuplicateInsuranceNameException;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DriverProductDevelopmentService {

    ProductPlanDevelopmentResponse plan(ProductPlanCreateRequest dto) throws DuplicateInsuranceNameException;

    @Transactional
    DriverProductDevelopmentDetailResponse design(DriverProductDesignRequest dto);

    @Transactional
    DriverProductDevelopmentDetailResponse authorize(Long id);

    Pagination<List<ProductPlanDevelopmentResponse>> list(Pageable pageable, DevelopmentState state);

    DriverProductDevelopmentDetailResponse read(Long id);

}
