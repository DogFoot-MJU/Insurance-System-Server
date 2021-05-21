package com.dogfoot.insurancesystemserver.domain.insurance.repository;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository<T extends Insurance> extends JpaRepository<T, Long> {

    Page<T> findAllByIsAvailableSale(boolean availableSale, Pageable pageable);

}
