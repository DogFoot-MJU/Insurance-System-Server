package com.dogfoot.insurancesystemserver.domain.productdevelopment.repository;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.CarProductDevelopment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarProductDevelopmentRepository extends JpaRepository<CarProductDevelopment, Long> {
}
