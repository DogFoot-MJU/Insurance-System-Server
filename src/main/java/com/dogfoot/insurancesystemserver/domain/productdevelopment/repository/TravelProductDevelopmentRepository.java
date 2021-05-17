package com.dogfoot.insurancesystemserver.domain.productdevelopment.repository;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.TravelProductDevelopment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelProductDevelopmentRepository extends JpaRepository<TravelProductDevelopment, Long> {
}
