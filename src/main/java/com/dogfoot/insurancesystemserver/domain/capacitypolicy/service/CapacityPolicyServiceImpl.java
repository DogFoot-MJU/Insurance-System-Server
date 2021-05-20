package com.dogfoot.insurancesystemserver.domain.capacitypolicy.service;

import com.dogfoot.insurancesystemserver.domain.capacitypolicy.dto.CapacityPolicyCreationRequest;
import com.dogfoot.insurancesystemserver.domain.capacitypolicy.repository.CapacityPolicyRepository;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import com.dogfoot.insurancesystemserver.domain.insurance.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CapacityPolicyServiceImpl implements CapacityPolicyService {

    private final CapacityPolicyRepository capacityPolicyRepository;
    private final InsuranceService insuranceService;

    @Override
    public void create(CapacityPolicyCreationRequest dto) {
        Insurance insurance = this.insuranceService.findById(dto.getInsuranceId());
        if (insurance.hasCapacityPolicy())
            throw new IllegalArgumentException("해당 보험 상품은 이미 인수 정책을 가지고 있습니다.");
        insurance.setCapacityPolicy(this.capacityPolicyRepository.save(dto.toEntity()));
    }

}
