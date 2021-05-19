package com.dogfoot.insurancesystemserver.domain.insurance.repository;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.FireInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FireInsuranceRepository extends JpaRepository<FireInsurance, Long> {
}
