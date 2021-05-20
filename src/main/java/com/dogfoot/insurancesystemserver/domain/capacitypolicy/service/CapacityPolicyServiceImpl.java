package com.dogfoot.insurancesystemserver.domain.capacitypolicy.service;

import com.dogfoot.insurancesystemserver.domain.capacitypolicy.domain.CapacityPolicy;
import com.dogfoot.insurancesystemserver.domain.capacitypolicy.dto.CapacityPolicyCreationRequest;
import com.dogfoot.insurancesystemserver.domain.capacitypolicy.dto.CapacityPolicyDetailResponse;
import com.dogfoot.insurancesystemserver.domain.capacitypolicy.dto.CapacityPolicyResponse;
import com.dogfoot.insurancesystemserver.domain.capacitypolicy.dto.CapacityPolicyUpdateRequest;
import com.dogfoot.insurancesystemserver.domain.capacitypolicy.repository.CapacityPolicyRepository;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import com.dogfoot.insurancesystemserver.domain.insurance.service.InsuranceService;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public Pagination<List<CapacityPolicyResponse>> list(Pageable pageable) {
        Page<CapacityPolicy> page = this.capacityPolicyRepository.findAll(pageable);
        List<CapacityPolicyResponse> data = page.getContent().stream()
                .map(CapacityPolicyResponse::from).collect(Collectors.toList());
        return Pagination.of(page, data);
    }

    @Override
    public CapacityPolicyDetailResponse read(Long id) {
        return CapacityPolicyDetailResponse.from(findById(id));
    }

    @Override
    public void update(CapacityPolicyUpdateRequest dto) {
        findById(dto.getId()).update(dto);
    }

    public CapacityPolicy findById(Long id) {
        return this.capacityPolicyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 인수 정책이 존재하지 않습니다."));
    }
}
