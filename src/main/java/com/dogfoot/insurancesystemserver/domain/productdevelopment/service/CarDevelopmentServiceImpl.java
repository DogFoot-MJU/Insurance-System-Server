package com.dogfoot.insurancesystemserver.domain.productdevelopment.service;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.CarInsurance;
import com.dogfoot.insurancesystemserver.domain.insurance.repository.InsuranceRepository;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.CarDevelopment;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.CarProductDesignRequest;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.CarProductDevelopmentDetailResponse;
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
public class CarDevelopmentServiceImpl implements DevelopmentService<CarProductDesignRequest, CarProductDevelopmentDetailResponse, CarDevelopment> {

    private final ProductDevelopmentRepository<CarDevelopment> productDevelopmentRepository;
    private final InsuranceRepository<CarInsurance> carInsuranceRepository;

    @Override
    public void plan(ProductPlanCreateRequest dto) {
        if (productDevelopmentRepository.existsByName(dto.getName()))
            throw new DuplicateInsuranceNameException("이름 중복.");
        productDevelopmentRepository.save(dto.toCarProductDevelopmentEntity());
    }

    @Override
    public void design(CarProductDesignRequest dto) {
        findById(dto.getId()).design(dto);
    }

    @Override
    public void authorize(Long id) {
        findById(id).authorize();
    }

    @Override
    public void approve(Long id) {
        carInsuranceRepository.save(findById(id).approve());
    }

    @Override
    public Pagination<List<ProductPlanDevelopmentResponse>> list(Pageable pageable, DevelopmentState state) {
        Page<CarDevelopment> page = productDevelopmentRepository.findAllByState(state, pageable);
        List<ProductPlanDevelopmentResponse> list = page.stream()
                .map(ProductPlanDevelopmentResponse::from)
                .collect(Collectors.toList());
        return Pagination.of(page, list);
    }

    @Override
    public CarProductDevelopmentDetailResponse read(Long id) {
        return CarProductDevelopmentDetailResponse.from(findById(id));
    }

    @Override
    public void delete(Long id) {
        this.productDevelopmentRepository.delete(findById(id));
    }

    public CarDevelopment findById(Long id) {
        return productDevelopmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품 개발이 존재하지 않습니다."));
    }

}
