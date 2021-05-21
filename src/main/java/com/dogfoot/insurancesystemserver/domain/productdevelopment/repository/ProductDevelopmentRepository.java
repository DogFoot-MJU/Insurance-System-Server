package com.dogfoot.insurancesystemserver.domain.productdevelopment.repository;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.ProductDevelopment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDevelopmentRepository<T extends ProductDevelopment> extends JpaRepository<T, Long> {

    boolean existsByName(String string);

    Page<T> findAllByState(DevelopmentState state, Pageable pageable);

}
