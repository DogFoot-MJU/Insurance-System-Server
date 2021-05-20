package com.dogfoot.insurancesystemserver.domain.insurance.repository;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.DriverInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverInsuranceRepository extends JpaRepository<DriverInsurance, Long> {
}
