package com.dogfoot.insurancesystemserver.domain.compensation.repository;

import com.dogfoot.insurancesystemserver.domain.compensation.domain.Compensation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompensationRepository extends JpaRepository<Compensation, Long> {
}
