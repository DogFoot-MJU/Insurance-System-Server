package com.dogfoot.insurancesystemserver.domain.productdevelopment.service;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.ProductPlanCreateRequest;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.ProductPlanDevelopmentResponse;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.TravelProductDesignRequest;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.TravelProductDevelopmentDetailResponse;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.exception.DuplicateInsuranceNameException;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TravelProductDevelopmentService {

    ProductPlanDevelopmentResponse plan(ProductPlanCreateRequest dto) throws DuplicateInsuranceNameException;

    @Transactional
    TravelProductDevelopmentDetailResponse design(TravelProductDesignRequest dto);

    @Transactional
    TravelProductDevelopmentDetailResponse authorize(Long id);

    Pagination<List<ProductPlanDevelopmentResponse>> list(Pageable pageable, DevelopmentState state);

    TravelProductDevelopmentDetailResponse read(Long id);

}
