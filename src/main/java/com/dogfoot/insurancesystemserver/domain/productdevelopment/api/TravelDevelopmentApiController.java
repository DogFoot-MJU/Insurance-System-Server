package com.dogfoot.insurancesystemserver.domain.productdevelopment.api;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.TravelDevelopment;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.TravelProductDesignRequest;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.TravelProductDevelopmentDetailResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/planner/travel/product/development")
@RestController
public class TravelDevelopmentApiController extends DevelopmentApiControllerImpl
        <TravelProductDesignRequest, TravelProductDevelopmentDetailResponse, TravelDevelopment> {
}
