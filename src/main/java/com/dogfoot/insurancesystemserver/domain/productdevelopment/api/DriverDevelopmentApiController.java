package com.dogfoot.insurancesystemserver.domain.productdevelopment.api;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DriverDevelopment;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.DriverProductDesignRequest;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.DriverProductDevelopmentDetailResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/planner/driver/product/development")
@RestController
public class DriverDevelopmentApiController extends DevelopmentApiControllerImpl
        <DriverProductDesignRequest, DriverProductDevelopmentDetailResponse, DriverDevelopment> {
}
