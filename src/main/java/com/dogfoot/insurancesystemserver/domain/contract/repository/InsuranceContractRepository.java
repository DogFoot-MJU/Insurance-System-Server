package com.dogfoot.insurancesystemserver.domain.contract.repository;

import com.dogfoot.insurancesystemserver.domain.contract.domain.InsuranceContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceContractRepository<T extends InsuranceContract> extends JpaRepository<T, Long> {
}
