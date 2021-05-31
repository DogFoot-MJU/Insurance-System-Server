package com.dogfoot.insurancesystemserver.domain.accident.repository;

import com.dogfoot.insurancesystemserver.domain.accident.domain.Accident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccidentRepository extends JpaRepository<Accident, Long> {
}
