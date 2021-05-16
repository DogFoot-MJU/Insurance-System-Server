package com.dogfoot.insurancesystemserver.domain.consulting.repository;

import com.dogfoot.insurancesystemserver.domain.consulting.domain.Consulting;
import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultingRepository extends JpaRepository<Consulting, Long> {

    Page<Consulting> findAllByUser(User user, Pageable pageable);

}
