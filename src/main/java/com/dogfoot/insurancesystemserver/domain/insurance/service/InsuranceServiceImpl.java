package com.dogfoot.insurancesystemserver.domain.insurance.service;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import com.dogfoot.insurancesystemserver.domain.insurance.repository.InsuranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InsuranceServiceImpl<T extends Insurance> implements InsuranceService<T> {

    private final InsuranceRepository<T> insuranceRepository;

    @Override
    public T findById(Long id) {
        return this.insuranceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 보험 상품을 찾을 수 없습니다."));
    }

}
