package com.dogfoot.insurancesystemserver.domain.insurance.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@SpringBootTest
class InsuranceRepositoryTest {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Test
    @DisplayName("Insurance read test")
    void insuranceReadTest() {
        insuranceRepository.findAll().forEach(i -> log.info(i.getName()));
    }

}