package com.dogfoot.insurancesystemserver.domain.productdevelopment.repository;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DriverProductDevelopment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverProductDevelopmentRepository extends JpaRepository<DriverProductDevelopment, Long> {

    boolean existsByName(String name);

    Page<DriverProductDevelopment> findAllByState(DevelopmentState state, Pageable pageable);

}
