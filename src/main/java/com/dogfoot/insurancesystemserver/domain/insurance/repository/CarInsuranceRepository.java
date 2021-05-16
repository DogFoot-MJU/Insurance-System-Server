package com.dogfoot.insurancesystemserver.domain.insurance.repository;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.CarInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarInsuranceRepository extends JpaRepository<CarInsurance, Long> {

    Optional<CarInsurance> findByName(String name);

}
