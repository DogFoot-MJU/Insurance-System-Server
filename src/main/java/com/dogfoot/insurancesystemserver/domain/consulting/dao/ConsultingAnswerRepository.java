package com.dogfoot.insurancesystemserver.domain.consulting.dao;

import com.dogfoot.insurancesystemserver.domain.consulting.domain.ConsultingAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultingAnswerRepository extends JpaRepository<ConsultingAnswer, Long> {
}
