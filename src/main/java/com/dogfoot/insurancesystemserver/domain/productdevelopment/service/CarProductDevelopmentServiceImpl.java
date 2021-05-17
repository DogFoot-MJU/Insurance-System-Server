package com.dogfoot.insurancesystemserver.domain.productdevelopment.service;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.CarProductDevelopment;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.CarProductDesignRequest;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.CarProductDevelopmentDetailResponse;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.ProductPlanCreateRequest;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.ProductPlanDevelopmentResponse;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.exception.DuplicateInsuranceNameException;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.repository.CarProductDevelopmentRepository;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CarProductDevelopmentServiceImpl implements CarProductDevelopmentService {

    protected final CarProductDevelopmentRepository carProductDevelopmentRepository;

    @Override
    public ProductPlanDevelopmentResponse plan(ProductPlanCreateRequest dto) throws DuplicateInsuranceNameException {
        if (carProductDevelopmentRepository.existsByName(dto.getName()))
            throw new DuplicateInsuranceNameException("이름 중복.");
        return ProductPlanDevelopmentResponse.from(carProductDevelopmentRepository.save(dto.toEntity()));
    }

    @Override
    public CarProductDevelopmentDetailResponse design(CarProductDesignRequest dto) {
        return CarProductDevelopmentDetailResponse.from(carProductDevelopmentRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 상품 개발이 존재하지 않습니다."))
                .design(dto));
    }

    @Override
    public CarProductDevelopmentDetailResponse authorize(Long id) {
        return CarProductDevelopmentDetailResponse.from(carProductDevelopmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품 개발이 존재하지 않습니다."))
                .authorize());
    }

    @Override
    public Pagination<List<ProductPlanDevelopmentResponse>> list(Pageable pageable, DevelopmentState state) {
        Page<CarProductDevelopment> page = carProductDevelopmentRepository.findAllByState(state, pageable);
        List<ProductPlanDevelopmentResponse> list = page.stream().map(ProductPlanDevelopmentResponse::from)
                .collect(Collectors.toList());
        return Pagination.of(page, list);
    }

    @Override
    public CarProductDevelopmentDetailResponse read(Long id) {
        return CarProductDevelopmentDetailResponse.from(carProductDevelopmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품 개발이 존재하지 않습니다.")));
    }

}
