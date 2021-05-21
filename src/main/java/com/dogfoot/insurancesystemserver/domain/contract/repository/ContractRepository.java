package com.dogfoot.insurancesystemserver.domain.contract.repository;

import com.dogfoot.insurancesystemserver.domain.contract.domain.InsuranceContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<InsuranceContract, Long> {
}
