package com.dogfoot.insurancesystemserver.domain.productdevelopment.repository;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.TravelProductDevelopment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelProductDevelopmentRepository extends JpaRepository<TravelProductDevelopment, Long> {

    boolean existsByName(String name);

    Page<TravelProductDevelopment> findAllByState(DevelopmentState state, Pageable pageable);

}
