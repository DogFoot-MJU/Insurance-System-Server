package com.dogfoot.insurancesystemserver.domain.contract.api;

import com.dogfoot.insurancesystemserver.domain.contract.domain.Contract;
import com.dogfoot.insurancesystemserver.domain.contract.dto.CalculatePaymentResponse;
import com.dogfoot.insurancesystemserver.domain.contract.service.ContractService;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class ContractApiControllerImpl<I extends Insurance, CreateReq, Res, C extends Contract<Res>> implements
        ContractApiController<CreateReq, Res> {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ContractService<I, CreateReq, Res, C> contractService;

    @Override
    public ResponseEntity<DefaultResponseDto> apply(PrincipalDetails principal, CreateReq dto) {
        contractService.create(principal, dto);
        return ResponseEntity.ok(DefaultResponseDto.from("보험 신청이 완료되었습니다."));
    }

    @Override
    public ResponseEntity<CalculatePaymentResponse> calculatePayment(PrincipalDetails principal, CreateReq dto) {
        return ResponseEntity.ok(contractService.calculateRequest(principal, dto));
    }

    @Override
    public ResponseEntity<Pagination<List<Res>>> dueProcessWaitList(Pageable pageable) {
        return ResponseEntity.ok(contractService.dueProcessWaitList(pageable));
    }
}
