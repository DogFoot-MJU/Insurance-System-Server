package com.dogfoot.insurancesystemserver.domain.insurance.repository;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}
