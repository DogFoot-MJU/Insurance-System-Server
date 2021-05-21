package com.dogfoot.insurancesystemserver.domain.contract.api;

import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InsuranceApiController<Req, Res, DetailRes> {

    ResponseEntity<DefaultResponseDto> create(Req dto);

    ResponseEntity<DetailRes> read(Long id);

    ResponseEntity<Pagination<List<Res>>> readAll(Pageable pageable);

//    ResponseEntity<DefaultResponseDto> cancel(Long id);

}
