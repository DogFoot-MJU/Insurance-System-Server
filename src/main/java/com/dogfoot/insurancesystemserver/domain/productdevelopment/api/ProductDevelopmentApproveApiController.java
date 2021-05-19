package com.dogfoot.insurancesystemserver.domain.productdevelopment.api;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.InsuranceType;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.service.CarProductDevelopmentService;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.service.DriverProductDevelopmentService;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.service.FireProductDevelopmentService;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.service.TravelProductDevelopmentService;
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
public class ProductDevelopmentApproveApiController {

    private final CarProductDevelopmentService carProductDevelopmentService;
    private final DriverProductDevelopmentService driverProductDevelopmentService;
    private final FireProductDevelopmentService fireProductDevelopmentService;
    private final TravelProductDevelopmentService travelProductDevelopmentService;

    @PutMapping("{product}/product/development/approve/{id}")
    public ResponseEntity<?> approve(@PathVariable InsuranceType product, @PathVariable Long id) {
        DefaultResponseDto dto = null;
        if (product.equals(InsuranceType.CAR)) {
            dto = carProductDevelopmentService.approve(id);
        } else if (product.equals(InsuranceType.DRIVER)) {
            dto = driverProductDevelopmentService.approve(id);
        } else if (product.equals(InsuranceType.FIRE)) {
            dto = fireProductDevelopmentService.approve(id);
        } else if (product.equals(InsuranceType.TRAVEL)) {
            dto = travelProductDevelopmentService.approve(id);
        }
        return ResponseEntity.ok(dto);
    }

}
