package com.dogfoot.insurancesystemserver.domain.contract.api;

import com.dogfoot.insurancesystemserver.domain.contract.dto.CalculatePaymentResponse;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface ContractApiController<CreateReq, Res> {

    @PostMapping("apply")
    ResponseEntity<DefaultResponseDto> apply(@AuthenticationPrincipal PrincipalDetails principal, @Valid @RequestBody CreateReq dto);

    @PostMapping("calculate")
    ResponseEntity<CalculatePaymentResponse> calculatePayment(@AuthenticationPrincipal PrincipalDetails principal, @Valid @RequestBody CreateReq dto);

    @GetMapping("uw/wait/list")
    ResponseEntity<Pagination<List<Res>>> dueProcessWaitList(@PageableDefault Pageable pageable);
//    ResponseEntity<DetailRes> read(Long id);

//    ResponseEntity<Pagination<List<Res>>> list(Pageable pageable);

//    ResponseEntity<DefaultResponseDto> cancel(Long id);

}
