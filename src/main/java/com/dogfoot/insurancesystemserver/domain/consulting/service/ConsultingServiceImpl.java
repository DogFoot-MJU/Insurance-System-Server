package com.dogfoot.insurancesystemserver.domain.consulting.service;

import com.dogfoot.insurancesystemserver.domain.consulting.constant.ConsultingResponseMessage;
import com.dogfoot.insurancesystemserver.domain.consulting.dto.ConsultingCreateRequest;
import com.dogfoot.insurancesystemserver.domain.consulting.repository.ConsultingRepository;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ConsultingServiceImpl implements ConsultingService {

    private final ConsultingRepository consultingRepository;

    @Transactional
    @Override
    public ResponseEntity<DefaultResponseDto> create(PrincipalDetails principal, ConsultingCreateRequest dto) {
        consultingRepository.save(dto.toEntity(principal.toEntity()));
        return ResponseEntity.ok(DefaultResponseDto.from(
                ConsultingResponseMessage.CONSULTING_SAVE_SUCCESS_MESSAGE.getMessage()));
    }

}
