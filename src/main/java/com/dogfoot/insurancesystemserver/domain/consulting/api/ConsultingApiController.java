package com.dogfoot.insurancesystemserver.domain.consulting.api;

import com.dogfoot.insurancesystemserver.domain.consulting.dto.ConsultingCreateRequest;
import com.dogfoot.insurancesystemserver.domain.consulting.service.ConsultingService;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("api/v1")
@RestController
public class ConsultingApiController {

    private final ConsultingService consultingService;

    @PostMapping("user/consulting")
    public ResponseEntity<DefaultResponseDto> save(@AuthenticationPrincipal PrincipalDetails principal,
                                                   @Valid @RequestBody ConsultingCreateRequest dto) {
        return this.consultingService.create(principal, dto);
    }

}
