package com.dogfoot.insurancesystemserver.domain.consulting.service;

import com.dogfoot.insurancesystemserver.domain.consulting.domain.Consulting;
import com.dogfoot.insurancesystemserver.domain.consulting.domain.ConsultingStateType;
import com.dogfoot.insurancesystemserver.domain.consulting.dto.ConsultingCreateRequest;
import com.dogfoot.insurancesystemserver.domain.consulting.dto.ConsultingResponse;
import com.dogfoot.insurancesystemserver.domain.consulting.repository.ConsultingRepository;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ConsultingServiceImpl implements ConsultingService {

    private final ConsultingRepository consultingRepository;

    @Override
    public void create(PrincipalDetails principal, ConsultingCreateRequest dto) {
        consultingRepository.save(dto.toEntity(principal.toEntity()));
    }

    @Override
    public Pagination<List<ConsultingResponse>> readAllForUser(Pageable pageable, PrincipalDetails principal) {
        Page<Consulting> page = this.consultingRepository.findAllByUser(principal.toEntity(), pageable);
        List<ConsultingResponse> responses = page.stream().map(ConsultingResponse::from).collect(Collectors.toList());
        return Pagination.of(page, responses);
    }

    @Override
    public Pagination<List<ConsultingResponse>> readAllForUw(Pageable pageable, ConsultingStateType type) {
        Page<Consulting> page = this.consultingRepository.findAllByState(type, pageable);
        List<ConsultingResponse> responses = page.stream().map(ConsultingResponse::from).collect(Collectors.toList());
        return Pagination.of(page, responses);
    }
}
