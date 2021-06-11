package com.dogfoot.insurancesystemserver.domain.accident.dao;

import com.dogfoot.insurancesystemserver.domain.accident.domain.Accident;
import com.dogfoot.insurancesystemserver.domain.accident.domain.AccidentState;
import com.dogfoot.insurancesystemserver.domain.contract.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccidentRepository extends JpaRepository<Accident, Long> {

    List<Accident> findAllByContract(Contract<?> contract);

    List<Accident> findAllByState(AccidentState state);

}
