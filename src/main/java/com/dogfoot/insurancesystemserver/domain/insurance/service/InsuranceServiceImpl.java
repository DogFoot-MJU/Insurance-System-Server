package com.dogfoot.insurancesystemserver.domain.insurance.service;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.InsuranceResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.repository.InsuranceRepository;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public abstract class InsuranceServiceImpl<DetailRes, T extends Insurance<DetailRes>> implements InsuranceService<DetailRes, T> {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private InsuranceRepository<T> insuranceRepository;

    @Override
    public Pagination<List<InsuranceResponse>> listByAvailableSale(Pageable pageable) {
        Specification<T> spec = getSpecification();
        Page<T> page = this.insuranceRepository.findAll(spec, pageable);
        List<InsuranceResponse> data = page.get().map(InsuranceResponse::from).collect(Collectors.toList());
//        Page<T> page = this.insuranceRepository.findAllByIsAvailableSale(true, pageable);
//        List<InsuranceResponse> data = page.getContent().stream().map(InsuranceResponse::from).collect(Collectors.toList());
        return Pagination.of(page, data);
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
