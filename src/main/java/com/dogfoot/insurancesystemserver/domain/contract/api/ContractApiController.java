package com.dogfoot.insurancesystemserver.domain.contract.api;

import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

//public interface ContractApiController<Req, Res, DetailRes> {
public interface ContractApiController<Req> {

    @PostMapping
    ResponseEntity<DefaultResponseDto> create(@AuthenticationPrincipal PrincipalDetails principal, @Valid @RequestBody Req dto);

//    ResponseEntity<DetailRes> read(Long id);

//    ResponseEntity<Pagination<List<Res>>> list(Pageable pageable);

//    ResponseEntity<DefaultResponseDto> cancel(Long id);

}
