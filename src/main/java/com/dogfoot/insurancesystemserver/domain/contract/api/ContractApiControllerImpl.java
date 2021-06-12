package com.dogfoot.insurancesystemserver.domain.contract.api;

import com.dogfoot.insurancesystemserver.domain.contract.constant.ContractConstants;
import com.dogfoot.insurancesystemserver.domain.contract.domain.Contract;
import com.dogfoot.insurancesystemserver.domain.contract.dto.CalculatePaymentResponse;
import com.dogfoot.insurancesystemserver.domain.contract.service.ContractService;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public abstract class ContractApiControllerImpl<I extends Insurance, CreateReq, Res, C extends Contract<Res>> implements
        ContractApiController<CreateReq> {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ContractService<I, CreateReq, Res, C> contractService;

    @Override
    public ResponseEntity<DefaultResponseDto> apply(PrincipalDetails principal, CreateReq dto) {
        contractService.create(principal, dto);
        return ResponseEntity.ok(DefaultResponseDto.from(ContractConstants.COMPLETE_APPLY_INSURANCE_CONTRACT.getMessage()));
    }

    @Override
    public ResponseEntity<CalculatePaymentResponse> calculatePayment(PrincipalDetails principal, CreateReq dto) {
        return ResponseEntity.ok(contractService.calculateRequest(principal, dto));
    }

}
