package com.dogfoot.insurancesystemserver.domain.contract.repository;

import com.dogfoot.insurancesystemserver.domain.contract.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository<T extends Contract> extends JpaRepository<T, Long> {
}
