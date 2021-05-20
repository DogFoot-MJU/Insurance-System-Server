package com.dogfoot.insurancesystemserver.domain.productdevelopment.api;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.service.CarDevelopmentServiceImpl;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.service.DriverDevelopmentServiceImpl;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.service.FireDevelopmentServiceImpl;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.service.TravelDevelopmentServiceImpl;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("api/v1/financial/supervisory")
@RestController
public class DevelopmentApproveApiController {

    private final CarDevelopmentServiceImpl carDevelopmentService;
    private final DriverDevelopmentServiceImpl driverDevelopmentService;
    private final FireDevelopmentServiceImpl fireDevelopmentService;
    private final TravelDevelopmentServiceImpl travelDevelopmentService;

    @PutMapping("car/product/development/approve/{id}")
    public ResponseEntity<DefaultResponseDto> approveCar(@PathVariable Long id) {
        carDevelopmentService.approve(id);
        return ResponseEntity.ok(DefaultResponseDto.from("승인 완료."));
    }

    @PutMapping("driver/product/development/approve/{id}")
    public ResponseEntity<DefaultResponseDto> approveDriver(@PathVariable Long id) {
        driverDevelopmentService.approve(id);
        return ResponseEntity.ok(DefaultResponseDto.from("승인 완료."));
    }

    @PutMapping("fire/product/development/approve/{id}")
    public ResponseEntity<DefaultResponseDto> approveFire(@PathVariable Long id) {
        fireDevelopmentService.approve(id);
        return ResponseEntity.ok(DefaultResponseDto.from("승인 완료."));
    }

    @PutMapping("travel/product/development/approve/{id}")
    public ResponseEntity<DefaultResponseDto> approveTravel(@PathVariable Long id) {
        travelDevelopmentService.approve(id);
        return ResponseEntity.ok(DefaultResponseDto.from("승인 완료."));
    }

}
