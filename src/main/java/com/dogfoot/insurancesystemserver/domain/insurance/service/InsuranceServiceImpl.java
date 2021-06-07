package com.dogfoot.insurancesystemserver.domain.insurance.service;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.InsuranceResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.repository.InsuranceRepository;
import com.dogfoot.insurancesystemserver.global.dto.PaginationDto;
import com.dogfoot.insurancesystemserver.global.util.ListSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public abstract class InsuranceServiceImpl<DetailRes, T extends Insurance> implements InsuranceService<DetailRes, T> {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private InsuranceRepository<T> insuranceRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected ListSpecification<T> specification;


    @Override
    public PaginationDto<List<InsuranceResponse>> listByAvailableSale(Pageable pageable) {
        Specification<T> spec = getAvailableSpecification();
        return getListPagination(pageable, spec);
    }

    @Override
    public PaginationDto<List<InsuranceResponse>> listByUnAvailableSale(Pageable pageable) {
        Specification<T> spec = getUnAvailableSpecification();
        return getListPagination(pageable, spec);
    }

    private PaginationDto<List<InsuranceResponse>> getListPagination(Pageable pageable, Specification<T> spec) {
        Page<T> page = this.insuranceRepository.findAll(spec, pageable);
        List<InsuranceResponse> data = page.get().map(InsuranceResponse::from).collect(Collectors.toList());
        return PaginationDto.of(page, data);
    }

    @Override
    public DetailRes read(Long id) {
        return this.findById(id).toDetailResponse();
    }

    @Override
    public T findById(Long id) {
        return this.insuranceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 보험 상품을 찾을 수 없습니다."));
    }

}
