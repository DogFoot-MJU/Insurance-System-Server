package com.dogfoot.insurancesystemserver.domain.productdevelopment.dao;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.ProductDevelopment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DevelopmentRepository<T extends ProductDevelopment> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

    boolean existsByName(String string);

    Page<T> findAllByState(DevelopmentState state, Pageable pageable);
//    Page<T> findAllByDtypeState(DevelopmentState state, Pageable pageable);

}
