package com.dogfoot.insurancesystemserver.domain.consulting.service;

import com.dogfoot.insurancesystemserver.domain.consulting.dto.ConsultingCreateRequest;
import com.dogfoot.insurancesystemserver.domain.consulting.dto.ConsultingResponse;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ConsultingService {

    ResponseEntity<DefaultResponseDto> create(PrincipalDetails principal,  ConsultingCreateRequest dto);

    ResponseEntity<Pagination<List<ConsultingResponse>>> readAllForUser(Pageable pageable, PrincipalDetails principal);
    
}
