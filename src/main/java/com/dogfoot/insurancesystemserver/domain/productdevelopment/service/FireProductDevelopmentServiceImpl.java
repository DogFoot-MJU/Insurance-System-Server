package com.dogfoot.insurancesystemserver.domain.productdevelopment.service;

import com.dogfoot.insurancesystemserver.domain.insurance.repository.FireInsuranceRepository;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.FireProductDevelopment;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.FireProductDesignRequest;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.FireProductDevelopmentDetailResponse;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.ProductPlanCreateRequest;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.ProductPlanDevelopmentResponse;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.exception.DuplicateInsuranceNameException;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.repository.FireProductDevelopmentRepository;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FireProductDevelopmentServiceImpl implements FireProductDevelopmentService {

    private final FireProductDevelopmentRepository fireProductDevelopmentRepository;
    private final FireInsuranceRepository fireInsuranceRepository;

    @Override
    public ProductPlanDevelopmentResponse plan(ProductPlanCreateRequest dto) throws DuplicateInsuranceNameException {
        if (fireProductDevelopmentRepository.existsByName(dto.getName()))
            throw new DuplicateInsuranceNameException("이름 중복.");
        return ProductPlanDevelopmentResponse.from(fireProductDevelopmentRepository.save(dto.toFireProductDevelopmentEntity()));
    }

    @Override
    public FireProductDevelopmentDetailResponse design(FireProductDesignRequest dto) {
        return FireProductDevelopmentDetailResponse.from(findById(dto.getId()).design(dto));
    }

    @Override
    public FireProductDevelopmentDetailResponse authorize(Long id) {
        return FireProductDevelopmentDetailResponse.from(findById(id).authorize());
    }

    @Override
    public DefaultResponseDto approve(Long id) {
        fireInsuranceRepository.save(findById(id).approve());
        return DefaultResponseDto.from("승인 완료.");
    }

    @Override
    public Pagination<List<ProductPlanDevelopmentResponse>> list(Pageable pageable, DevelopmentState state) {
        Page<FireProductDevelopment> page = fireProductDevelopmentRepository.findAllByState(state, pageable);
        List<ProductPlanDevelopmentResponse> list = page.stream().map(ProductPlanDevelopmentResponse::from)
                .collect(Collectors.toList());
        return Pagination.of(page, list);
    }

    @Override
    public FireProductDevelopmentDetailResponse read(Long id) {
        return FireProductDevelopmentDetailResponse.from(findById(id));
    }

    private FireProductDevelopment findById(Long id) {
        return fireProductDevelopmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품 개발이 존재하지 않습니다."));
    }

}
