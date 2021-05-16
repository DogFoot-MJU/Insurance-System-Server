package com.dogfoot.insurancesystemserver.domain.consulting.service;

import com.dogfoot.insurancesystemserver.domain.consulting.dto.ConsultingAnswerResponse;
import com.dogfoot.insurancesystemserver.domain.consulting.dto.ConsultingAnswerSaveRequest;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;

public interface ConsultingAnswerService {

    void create(PrincipalDetails principal, ConsultingAnswerSaveRequest dto);

    ConsultingAnswerResponse read(PrincipalDetails principal, Long id);

}
