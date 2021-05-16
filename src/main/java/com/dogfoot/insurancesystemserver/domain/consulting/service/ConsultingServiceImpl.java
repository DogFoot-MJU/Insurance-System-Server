package com.dogfoot.insurancesystemserver.domain.consulting.service;

import com.dogfoot.insurancesystemserver.domain.consulting.constant.ConsultingResponseMessage;
import com.dogfoot.insurancesystemserver.domain.consulting.domain.Consulting;
import com.dogfoot.insurancesystemserver.domain.consulting.dto.ConsultingCreateRequest;
import com.dogfoot.insurancesystemserver.domain.consulting.dto.ConsultingResponse;
import com.dogfoot.insurancesystemserver.domain.consulting.repository.ConsultingRepository;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ConsultingServiceImpl implements ConsultingService {

    private final ConsultingRepository consultingRepository;

    @Override
    public ResponseEntity<DefaultResponseDto> create(PrincipalDetails principal, ConsultingCreateRequest dto) {
        consultingRepository.save(dto.toEntity(principal.toEntity()));
        return ResponseEntity.ok(DefaultResponseDto.from(
                ConsultingResponseMessage.CONSULTING_SAVE_SUCCESS_MESSAGE.getMessage()));
    }

    @Override
    public ResponseEntity<Pagination<List<ConsultingResponse>>> readAllForUser(Pageable pageable, PrincipalDetails principal) {
        Page<Consulting> page = this.consultingRepository.findAllByUser(principal.toEntity(), pageable);
        List<ConsultingResponse> responses = page.stream().map(ConsultingResponse::from).collect(Collectors.toList());
        return ResponseEntity.ok(Pagination.of(page, responses));
    }
}
