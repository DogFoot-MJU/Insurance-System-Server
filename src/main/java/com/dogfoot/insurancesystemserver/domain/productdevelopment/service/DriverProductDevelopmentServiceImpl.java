package com.dogfoot.insurancesystemserver.domain.productdevelopment.service;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DriverProductDevelopment;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.*;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.exception.DuplicateInsuranceNameException;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.repository.DriverProductDevelopmentRepository;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DriverProductDevelopmentServiceImpl implements DriverProductDevelopmentService {

    private final DriverProductDevelopmentRepository driverProductDevelopmentRepository;

    @Override
    public ProductPlanDevelopmentResponse plan(ProductPlanCreateRequest dto) throws DuplicateInsuranceNameException {
        if (driverProductDevelopmentRepository.existsByName(dto.getName()))
            throw new DuplicateInsuranceNameException("이름 중복.");
        return ProductPlanDevelopmentResponse.from(driverProductDevelopmentRepository.save(dto.toDriverProductDevelopmentEntity()));
    }

    @Override
    public DriverProductDevelopmentDetailResponse design(DriverProductDesignRequest dto) {
        return DriverProductDevelopmentDetailResponse.from(driverProductDevelopmentRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 상품 개발이 존재하지 않습니다."))
                .design(dto));
    }

    @Override
    public DriverProductDevelopmentDetailResponse authorize(Long id) {
        return DriverProductDevelopmentDetailResponse.from(driverProductDevelopmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품 개발이 존재하지 않습니다."))
                .authorize());
    }

    @Override
    public Pagination<List<ProductPlanDevelopmentResponse>> list(Pageable pageable, DevelopmentState state) {
        Page<DriverProductDevelopment> page = driverProductDevelopmentRepository.findAllByState(state, pageable);
        List<ProductPlanDevelopmentResponse> list = page.stream().map(ProductPlanDevelopmentResponse::from)
                .collect(Collectors.toList());
        return Pagination.of(page, list);
    }

    @Override
    public DriverProductDevelopmentDetailResponse read(Long id) {
        return DriverProductDevelopmentDetailResponse.from(driverProductDevelopmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품 개발이 존재하지 않습니다.")));
    }

}
