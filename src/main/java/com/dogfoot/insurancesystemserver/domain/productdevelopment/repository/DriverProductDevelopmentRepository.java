package com.dogfoot.insurancesystemserver.domain.productdevelopment.repository;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DriverProductDevelopment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverProductDevelopmentRepository extends JpaRepository<DriverProductDevelopment, Long> {
}
