package com.dogfoot.insurancesystemserver.domain.productdevelopment.api;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.ProductPlanDevelopmentResponse;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.service.CarDevelopmentServiceImpl;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.service.DriverDevelopmentServiceImpl;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.service.FireDevelopmentServiceImpl;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.service.TravelDevelopmentServiceImpl;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/v1/financial/supervisory")
@RestController
public class DevelopmentApproveApiController {

    private final CarDevelopmentServiceImpl carDevelopmentService;
    private final DriverDevelopmentServiceImpl driverDevelopmentService;
    private final FireDevelopmentServiceImpl fireDevelopmentService;
    private final TravelDevelopmentServiceImpl travelDevelopmentService;

    @GetMapping("car/product/development/authorize/list")
    public ResponseEntity<Pagination<List<ProductPlanDevelopmentResponse>>> carListByAuthorize(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(carDevelopmentService.list(pageable, DevelopmentState.AUTHORIZE));
    }

    @GetMapping("driver/product/development/authorize/list")
    public ResponseEntity<Pagination<List<ProductPlanDevelopmentResponse>>> driverListByAuthorize(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(driverDevelopmentService.list(pageable, DevelopmentState.AUTHORIZE));
    }

    @GetMapping("fire/product/development/authorize/list")
    public ResponseEntity<Pagination<List<ProductPlanDevelopmentResponse>>> FireListByAuthorize(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(fireDevelopmentService.list(pageable, DevelopmentState.AUTHORIZE));
    }

    @GetMapping("travel/product/development/authorize/list")
    public ResponseEntity<Pagination<List<ProductPlanDevelopmentResponse>>> travelListByAuthorize(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(travelDevelopmentService.list(pageable, DevelopmentState.AUTHORIZE));
    }

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
