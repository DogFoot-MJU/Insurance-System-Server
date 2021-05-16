package com.dogfoot.insurancesystemserver.domain.consulting.service;

import com.dogfoot.insurancesystemserver.domain.consulting.dto.ConsultingCreateRequest;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import org.springframework.http.ResponseEntity;

public interface ConsultingService {

    ResponseEntity<DefaultResponseDto> create(PrincipalDetails principal,  ConsultingCreateRequest dto);

}
