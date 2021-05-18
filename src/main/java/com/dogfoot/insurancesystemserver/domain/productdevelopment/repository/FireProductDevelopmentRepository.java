package com.dogfoot.insurancesystemserver.domain.productdevelopment.repository;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.FireProductDevelopment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FireProductDevelopmentRepository extends JpaRepository<FireProductDevelopment, Long> {

    boolean existsByName(String name);

    Page<FireProductDevelopment> findAllByState(DevelopmentState state, Pageable pageable);

}
