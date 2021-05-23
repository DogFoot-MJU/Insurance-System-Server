package com.dogfoot.insurancesystemserver.domain.contract.api;

import com.dogfoot.insurancesystemserver.domain.contract.dto.CarContractCreateCreateRequest;
import com.dogfoot.insurancesystemserver.domain.contract.service.CarContractService;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("api/v1/contract/car")
@RestController
public class CarContractApiController implements ContractApiController<CarContractCreateCreateRequest> {

    private final CarContractService carContractService;

    @Override
    public ResponseEntity<DefaultResponseDto> create(PrincipalDetails principal, CarContractCreateCreateRequest dto) {
        carContractService.create(principal, dto);
        return ResponseEntity.ok(DefaultResponseDto.from("보험료를 확인 후 수락 또는 거절을 해주세요."));
    }

}
