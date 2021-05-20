package com.dogfoot.insurancesystemserver.domain.productdevelopment.repository;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.ProductDevelopment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDevelopmentRepository extends JpaRepository<ProductDevelopment, Long> {

    boolean existsByName(String string);

}
