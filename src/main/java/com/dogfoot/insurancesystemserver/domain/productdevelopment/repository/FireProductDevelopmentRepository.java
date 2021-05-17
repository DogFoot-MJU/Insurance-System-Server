package com.dogfoot.insurancesystemserver.domain.productdevelopment.repository;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.FireProductDevelopment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FireProductDevelopmentRepository extends JpaRepository<FireProductDevelopment, Long> {
}
