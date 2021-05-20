package com.dogfoot.insurancesystemserver.domain.capacitypolicy.service;

import com.dogfoot.insurancesystemserver.domain.capacitypolicy.dto.CapacityPolicyCreationRequest;
import com.dogfoot.insurancesystemserver.domain.capacitypolicy.dto.CapacityPolicyResponse;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CapacityPolicyService {

    @Transactional
    void create(CapacityPolicyCreationRequest dto);

    Pagination<List<CapacityPolicyResponse>> list(Pageable pageable);
}
