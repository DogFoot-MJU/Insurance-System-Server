package com.dogfoot.insurancesystemserver.domain.capacitypolicy.service;

import com.dogfoot.insurancesystemserver.domain.capacitypolicy.domain.CapacityPolicy;
import com.dogfoot.insurancesystemserver.domain.capacitypolicy.dto.CapacityPolicyCreationRequest;
import com.dogfoot.insurancesystemserver.domain.capacitypolicy.dto.CapacityPolicyDetailResponse;
import com.dogfoot.insurancesystemserver.domain.capacitypolicy.dto.CapacityPolicyResponse;
import com.dogfoot.insurancesystemserver.domain.capacitypolicy.dto.CapacityPolicyUpdateRequest;
import com.dogfoot.insurancesystemserver.domain.capacitypolicy.dao.CapacityPolicyRepository;
import com.dogfoot.insurancesystemserver.domain.capacitypolicy.exception.AlreadyHaveCapacityPolicyException;
import com.dogfoot.insurancesystemserver.domain.capacitypolicy.exception.CapacityPolicyExceptionMessages;
import com.dogfoot.insurancesystemserver.domain.capacitypolicy.exception.CapacityPolicyNotFoundException;
import com.dogfoot.insurancesystemserver.domain.insurance.exception.InsuranceExceptionMessages;
import com.dogfoot.insurancesystemserver.domain.insurance.exception.InsuranceNotFoundException;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import com.dogfoot.insurancesystemserver.domain.insurance.dao.InsuranceRepository;
import com.dogfoot.insurancesystemserver.global.dto.PaginationDto;
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
    private final InsuranceRepository<Insurance> insuranceRepository;

    @Override
    public void create(CapacityPolicyCreationRequest dto) {
        Insurance insurance = this.insuranceRepository.findById(dto.getInsuranceId())
                .orElseThrow(() -> new InsuranceNotFoundException(InsuranceExceptionMessages.INSURANCE_NOT_FOUND_EXCEPTION_MESSAGE));
        if (insurance.hasCapacityPolicy())
            throw new AlreadyHaveCapacityPolicyException(CapacityPolicyExceptionMessages.ALREADY_HAVE_CAPACITY_POLICY_EXCEPTION_MESSAGE);
        insurance.setCapacityPolicy(this.capacityPolicyRepository.save(dto.toEntity()));
    }

    @Override
    public PaginationDto<List<CapacityPolicyResponse>> list(Pageable pageable) {
        Page<CapacityPolicy> page = this.capacityPolicyRepository.findAll(pageable);
        List<CapacityPolicyResponse> data = page.getContent().stream().map(CapacityPolicyResponse::from).collect(Collectors.toList());
        return PaginationDto.of(page, data);
    }

    @Override
    public CapacityPolicyDetailResponse read(Long id) {
        return CapacityPolicyDetailResponse.from(findById(id));
    }

    @Override
    public void update(CapacityPolicyUpdateRequest dto) {
        findById(dto.getId()).update(dto);
    }

    @Override
    public void delete(Long id) {
        this.capacityPolicyRepository.delete(findById(id).removeInsurance());
    }

    public CapacityPolicy findById(Long id) {
        return this.capacityPolicyRepository.findById(id)
                .orElseThrow(() -> new CapacityPolicyNotFoundException(CapacityPolicyExceptionMessages.CAPACITY_POLICY_NOT_FOUND_EXCEPTION_MESSAGE));
    }
}
