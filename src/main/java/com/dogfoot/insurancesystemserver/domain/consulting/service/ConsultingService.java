package com.dogfoot.insurancesystemserver.domain.consulting.service;

import com.dogfoot.insurancesystemserver.domain.consulting.domain.ConsultingStateType;
import com.dogfoot.insurancesystemserver.domain.consulting.dto.ConsultingDetailResponse;
import com.dogfoot.insurancesystemserver.domain.consulting.dto.ConsultingResponse;
import com.dogfoot.insurancesystemserver.domain.consulting.dto.ConsultingSaveRequest;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import com.dogfoot.insurancesystemserver.global.dto.PaginationDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ConsultingService {

    void create(PrincipalDetails principal,  ConsultingSaveRequest dto);

    PaginationDto<List<ConsultingResponse>> readAllForUser(Pageable pageable, PrincipalDetails principal);

    PaginationDto<List<ConsultingResponse>> readAllForUw(Pageable pageable, ConsultingStateType type);

    ConsultingDetailResponse read(PrincipalDetails principal, Long id);

}
