package com.dogfoot.insurancesystemserver.domain.insurance.repository;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.TravelInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelInsuranceRepository extends JpaRepository<TravelInsurance, Long> {
}
