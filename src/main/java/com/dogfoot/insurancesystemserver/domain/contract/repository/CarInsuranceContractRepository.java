package com.dogfoot.insurancesystemserver.domain.contract.repository;

import com.dogfoot.insurancesystemserver.domain.contract.domain.CarInsuranceContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarInsuranceContractRepository extends JpaRepository<CarInsuranceContract, Long> {
}
