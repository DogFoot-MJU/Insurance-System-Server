package com.dogfoot.insurancesystemserver.domain.productdevelopment.service;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.DriverInsurance;
import com.dogfoot.insurancesystemserver.domain.insurance.dao.InsuranceRepository;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DriverDevelopment;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.DriverProductDesignRequest;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.DriverProductDevelopmentDetailResponse;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.ProductPlanCreateRequest;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.ProductPlanDevelopmentResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.exception.DuplicateInsuranceNameException;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dao.DevelopmentRepository;
import com.dogfoot.insurancesystemserver.global.util.ListSpecification;
import com.dogfoot.insurancesystemserver.global.dto.PaginationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DriverDevelopmentServiceImpl implements DevelopmentService<DriverProductDesignRequest, DriverProductDevelopmentDetailResponse, DriverDevelopment> {

    private final DevelopmentRepository<DriverDevelopment> developmentRepository;
    private final InsuranceRepository<DriverInsurance> driverInsuranceRepository;
    private final ListSpecification<DriverDevelopment> specification;

    @Override
    public void plan(ProductPlanCreateRequest dto) {
        if (developmentRepository.existsByName(dto.getName()))
            throw new DuplicateInsuranceNameException("?????? ??????.");
        developmentRepository.save(dto.toDriverProductDevelopmentEntity());
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
    public PaginationDto<List<ProductPlanDevelopmentResponse>> list(Pageable pageable, DevelopmentState state) {
        Specification<DriverDevelopment> spec = Specification.where(specification.equalToType("Driver")).and(specification.equalToState(state));
        Page<DriverDevelopment> page = developmentRepository.findAll(spec, pageable);
        List<ProductPlanDevelopmentResponse> list = page.get().map(DriverDevelopment::toResponse).collect(Collectors.toList());
        return PaginationDto.of(page, list);
    }

    @Override
    public DriverProductDevelopmentDetailResponse read(Long id) {
        return DriverProductDevelopmentDetailResponse.from(findById(id));
    }

    @Override
    public void delete(Long id) {
        this.developmentRepository.delete(findById(id));
    }

    @Override
    public DriverDevelopment findById(Long id) {
        return developmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("?????? ?????? ????????? ???????????? ????????????."));
    }

}
