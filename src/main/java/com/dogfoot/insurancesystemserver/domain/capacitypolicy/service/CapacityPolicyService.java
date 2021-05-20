package com.dogfoot.insurancesystemserver.domain.capacitypolicy.service;

import com.dogfoot.insurancesystemserver.domain.capacitypolicy.dto.CapacityPolicyCreationRequest;
import org.springframework.transaction.annotation.Transactional;

public interface CapacityPolicyService {

    @Transactional
    void create(CapacityPolicyCreationRequest dto);

}
