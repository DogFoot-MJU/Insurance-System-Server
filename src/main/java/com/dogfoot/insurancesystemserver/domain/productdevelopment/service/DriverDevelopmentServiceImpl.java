package com.dogfoot.insurancesystemserver.domain.productdevelopment.service;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.DriverInsurance;
import com.dogfoot.insurancesystemserver.domain.insurance.repository.InsuranceRepository;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DriverDevelopment;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.DriverProductDesignRequest;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.DriverProductDevelopmentDetailResponse;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.ProductPlanCreateRequest;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.ProductPlanDevelopmentResponse;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.exception.DuplicateInsuranceNameException;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.repository.ProductDevelopmentRepository;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DriverDevelopmentServiceImpl implements DevelopmentService<DriverProductDesignRequest, DriverProductDevelopmentDetailResponse, DriverDevelopment> {

    private final ProductDevelopmentRepository<DriverDevelopment> productDevelopmentRepository;
    private final InsuranceRepository<DriverInsurance> driverInsuranceRepository;

    @Override
    public void plan(ProductPlanCreateRequest dto) {
        if (productDevelopmentRepository.existsByName(dto.getName()))
            throw new DuplicateInsuranceNameException("이름 중복.");
        productDevelopmentRepository.save(dto.toDriverProductDevelopmentEntity());
    }

    @Override
    public void design(DriverProductDesignRequest dto) {
        findById(dto.getId()).design(dto);
    }

    @Override
    public void authorize(Long id) {
        findById(id).authorize();
    }

    @Override
    public void approve(Long id) {
        driverInsuranceRepository.save(findById(id).approve());
    }

    @Override
    public Pagination<List<ProductPlanDevelopmentResponse>> list(Pageable pageable, DevelopmentState state) {
        Page<DriverDevelopment> page = productDevelopmentRepository.findAllByState(state, pageable);
        List<ProductPlanDevelopmentResponse> list = page.stream().map(ProductPlanDevelopmentResponse::from)
                .collect(Collectors.toList());
        return Pagination.of(page, list);
    }

    @Override
    public DriverProductDevelopmentDetailResponse read(Long id) {
        return DriverProductDevelopmentDetailResponse.from(findById(id));
    }

    @Override
    public void delete(Long id) {
        this.productDevelopmentRepository.delete(findById(id));
    }

    @Override
    public DriverDevelopment findById(Long id) {
        return productDevelopmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품 개발이 존재하지 않습니다."));
    }
}
