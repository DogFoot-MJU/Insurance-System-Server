package com.dogfoot.insurancesystemserver.domain.insurance.domain;

import com.dogfoot.insurancesystemserver.domain.insurance.repository.CarInsuranceRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@SpringBootTest
class CarInsuranceTest {

    @Autowired
    private CarInsuranceRepository carInsuranceRepository;

    @Test
    @DisplayName("car insurance save test")
    @Transactional
    void carInsuranceSaveTest() {
        CarInsurance save = carInsuranceRepository.save(CarInsurance.builder()
                .name("car 3 insurance")
                .payment(200L)
                .drivingDistance(2000L)
                .carPrice(8888L)
                .build());
        log.info(save.getCarPrice());
        Assertions.assertEquals(8888L, save.getCarPrice());
    }

    @Test
    @DisplayName("car insurance read test")
    void carInsuranceReadTest() {
        CarInsurance carInsurance = carInsuranceRepository.findByName("car 3 insurance")
                .orElseThrow(() -> new IllegalArgumentException("No found insurance"));
        log.info(carInsurance.getName());
        Assertions.assertEquals("car 3 insurance", carInsurance.getName());
    }

}