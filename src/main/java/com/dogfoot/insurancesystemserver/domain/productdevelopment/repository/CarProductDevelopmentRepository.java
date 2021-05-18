package com.dogfoot.insurancesystemserver.domain.productdevelopment.repository;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.CarProductDevelopment;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarProductDevelopmentRepository extends JpaRepository<CarProductDevelopment, Long> {

    boolean existsByName(String name);

    Page<CarProductDevelopment> findAllByState(DevelopmentState state, Pageable pageable);

}
