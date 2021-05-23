package com.dogfoot.insurancesystemserver.domain.contract.api;

import com.dogfoot.insurancesystemserver.domain.contract.service.ContractService;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public abstract class ContractApiControllerImpl<I extends Insurance, CreateReq> implements ContractApiController<CreateReq> {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ContractService<I, CreateReq> contractService;

    @Override
    public ResponseEntity<DefaultResponseDto> create(PrincipalDetails principal, CreateReq dto) {
        contractService.create(principal, dto);
        return ResponseEntity.ok(DefaultResponseDto.from("보험료를 확인 후 수락 또는 거절을 해주세요."));
    }

}
