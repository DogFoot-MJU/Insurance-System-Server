package com.dogfoot.insurancesystemserver.domain.contract.api;

import com.dogfoot.insurancesystemserver.domain.contract.dto.CalculatePaymentResponse;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface ContractApiController<CreateReq> {

    @PostMapping("apply")
    ResponseEntity<DefaultResponseDto> apply(@AuthenticationPrincipal PrincipalDetails principal, @Valid @RequestBody CreateReq dto);

    @PostMapping("calculate")
    ResponseEntity<CalculatePaymentResponse> calculatePayment(@AuthenticationPrincipal PrincipalDetails principal, @Valid @RequestBody CreateReq dto);

}
