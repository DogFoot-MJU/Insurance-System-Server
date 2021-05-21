package com.dogfoot.insurancesystemserver.domain.contract.api;

import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import org.springframework.http.ResponseEntity;

public interface InsuranceApiController<Req, Res, DetailRes> {

    ResponseEntity<DefaultResponseDto> create(Req dto);

//    ResponseEntity<DetailRes> read(Long id);

//    ResponseEntity<Pagination<List<Res>>> list(Pageable pageable);

//    ResponseEntity<DefaultResponseDto> cancel(Long id);

}
