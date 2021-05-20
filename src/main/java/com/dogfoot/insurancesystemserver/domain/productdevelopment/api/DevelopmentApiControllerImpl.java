package com.dogfoot.insurancesystemserver.domain.productdevelopment.api;

import com.dogfoot.insurancesystemserver.domain.productdevelopment.domain.DevelopmentState;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.ProductPlanCreateRequest;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.dto.ProductPlanDevelopmentResponse;
import com.dogfoot.insurancesystemserver.domain.productdevelopment.service.DevelopmentService;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class DevelopmentApiControllerImpl<DesignReq, DetailRes, Entity> implements DevelopmentApiController<DesignReq, DetailRes> {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected DevelopmentService<DesignReq, DetailRes, Entity> developmentService;

    @Override
    public ResponseEntity<DefaultResponseDto> plan(ProductPlanCreateRequest dto) {
        this.developmentService.plan(dto);
        return ResponseEntity.ok(DefaultResponseDto.from("기획 작성 완료"));
    }

    @Override
    public ResponseEntity<DefaultResponseDto> design(DesignReq dto) {
        this.developmentService.design(dto);
        return ResponseEntity.ok(DefaultResponseDto.from("설계 작성 완료"));
    }

    @Override
    public ResponseEntity<DefaultResponseDto> authorize(Long id) {
        this.developmentService.authorize(id);
        return ResponseEntity.ok(DefaultResponseDto.from("인가 작성 완료"));
    }

    @Override
    public ResponseEntity<Pagination<List<ProductPlanDevelopmentResponse>>> list(Pageable pageable, DevelopmentState state) {
        return ResponseEntity.ok(this.developmentService.list(pageable, state));
    }

    @Override
    public ResponseEntity<DetailRes> read(Long id) {
        return ResponseEntity.ok(this.developmentService.read(id));
    }

    @Override
    public ResponseEntity<DefaultResponseDto> delete(Long id) {
        this.developmentService.delete(id);
        return ResponseEntity.ok(DefaultResponseDto.from("삭제 완료"));
    }
}
