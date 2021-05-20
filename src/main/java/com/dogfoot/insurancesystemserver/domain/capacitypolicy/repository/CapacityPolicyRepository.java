package com.dogfoot.insurancesystemserver.domain.capacitypolicy.repository;

import com.dogfoot.insurancesystemserver.domain.capacitypolicy.domain.CapacityPolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CapacityPolicyRepository extends JpaRepository<CapacityPolicy, Long> {
}
