package com.dogfoot.insurancesystemserver.domain.productdevelopment.service;

import com.dogfoot.insurancesystemserver.domain.insurance.repository.TravelInsuranceRepository;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.TravelProductDevelopment;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.ProductPlanCreateRequest;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.ProductPlanDevelopmentResponse;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.TravelProductDesignRequest;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.TravelProductDevelopmentDetailResponse;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.exception.DuplicateInsuranceNameException;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.repository.TravelProductDevelopmentRepository;
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
public class TravelProductDevelopmentServiceImpl implements TravelProductDevelopmentService {

    private final TravelProductDevelopmentRepository travelProductDevelopmentRepository;
    private final TravelInsuranceRepository travelInsuranceRepository;

    @Override
    public ProductPlanDevelopmentResponse plan(ProductPlanCreateRequest dto) throws DuplicateInsuranceNameException {
        if (travelProductDevelopmentRepository.existsByName(dto.getName()))
            throw new DuplicateInsuranceNameException("이름 중복.");
        return ProductPlanDevelopmentResponse.from(travelProductDevelopmentRepository.save(dto.toTravelProductDevelopmentEntity()));
    }

    @Override
    public TravelProductDevelopmentDetailResponse design(TravelProductDesignRequest dto) {
        return TravelProductDevelopmentDetailResponse.from(travelProductDevelopmentRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 상품 개발이 존재하지 않습니다."))
                .design(dto));
    }

    @Override
    public TravelProductDevelopmentDetailResponse authorize(Long id) {
        return TravelProductDevelopmentDetailResponse.from(travelProductDevelopmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품 개발이 존재하지 않습니다."))
                .authorize());
    }

    @Override
    public DefaultResponseDto approve(Long id) {
        travelInsuranceRepository.save(travelProductDevelopmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품 개발이 존재하지 않습니다."))
                .approve());
        return DefaultResponseDto.from("승인 완료.");
    }

    @Override
    public Pagination<List<ProductPlanDevelopmentResponse>> list(Pageable pageable, DevelopmentState state) {
        Page<TravelProductDevelopment> page = travelProductDevelopmentRepository.findAllByState(state, pageable);
        List<ProductPlanDevelopmentResponse> list = page.stream().map(ProductPlanDevelopmentResponse::from)
                .collect(Collectors.toList());
        return Pagination.of(page, list);
    }

    @Override
    public TravelProductDevelopmentDetailResponse read(Long id) {
        return TravelProductDevelopmentDetailResponse.from(travelProductDevelopmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품 개발이 존재하지 않습니다.")));
    }

}
