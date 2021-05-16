package com.dogfoot.insurancesystemserver.domain.consulting.repository;

import com.dogfoot.insurancesystemserver.domain.consulting.domain.Consulting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultingRepository extends JpaRepository<Consulting, Long> {
}
