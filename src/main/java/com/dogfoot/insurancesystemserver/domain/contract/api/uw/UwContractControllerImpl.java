package com.dogfoot.insurancesystemserver.domain.contract.api.uw;

import com.dogfoot.insurancesystemserver.domain.contract.domain.Contract;
import com.dogfoot.insurancesystemserver.domain.contract.service.ContractService;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class UwContractControllerImpl<I extends Insurance, Res, C extends Contract<Res>> implements UwContractController<Res> {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ContractService<I, ?, Res, C> contractService;

    @Override
    public ResponseEntity<Pagination<List<Res>>> dueProcessWaitList(Pageable pageable) {
        return ResponseEntity.ok(contractService.dueProcessWaitList(pageable));
    }

    @Override
    public ResponseEntity<Res> read(PrincipalDetails principal, Long id) {
        return ResponseEntity.ok(contractService.read(principal, id));
    }

    @Override
    public ResponseEntity<DefaultResponseDto> uwApprove(PrincipalDetails principal, Long id) {
        this.contractService.uwApprove(principal, id);
        return ResponseEntity.ok(DefaultResponseDto.from("계약 승인을 완료했습니다."));
    }

    @Override
    public ResponseEntity<DefaultResponseDto> uwReject(PrincipalDetails principal, Long id) {
        this.contractService.uwReject(principal, id);
        return ResponseEntity.ok(DefaultResponseDto.from("계약 거절을 완료했습니다."));
    }
}
