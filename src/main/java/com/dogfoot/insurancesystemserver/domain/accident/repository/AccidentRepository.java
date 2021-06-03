package com.dogfoot.insurancesystemserver.domain.accident.repository;

import com.dogfoot.insurancesystemserver.domain.accident.domain.Accident;
import com.dogfoot.insurancesystemserver.domain.contract.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccidentRepository extends JpaRepository<Accident, Long> {

    List<Accident> findByContract(Contract<?> contract);

}
