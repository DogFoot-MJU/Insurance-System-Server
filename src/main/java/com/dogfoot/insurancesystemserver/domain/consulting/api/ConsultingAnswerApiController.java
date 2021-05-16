package com.dogfoot.insurancesystemserver.domain.consulting.api;

import com.dogfoot.insurancesystemserver.domain.consulting.dto.ConsultingAnswerResponse;
import com.dogfoot.insurancesystemserver.domain.consulting.dto.ConsultingAnswerSaveRequest;
import com.dogfoot.insurancesystemserver.domain.consulting.service.ConsultingAnswerService;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("api/v1")
@RestController
public class ConsultingAnswerApiController {

    private final ConsultingAnswerService consultingAnswerService;

    @PostMapping("seller/consulting/answer")
    public ResponseEntity<DefaultResponseDto> save(@AuthenticationPrincipal PrincipalDetails principal,
                                                   @RequestBody ConsultingAnswerSaveRequest dto) {
        this.consultingAnswerService.create(principal, dto);
        return ResponseEntity.ok(DefaultResponseDto.from("해당 상담의 답변을 완료했습니다."));
    }

    @GetMapping("user/consulting/answer/{id}")
    public ResponseEntity<ConsultingAnswerResponse> read(@AuthenticationPrincipal PrincipalDetails principal,
                                                         @PathVariable Long id) {
        return ResponseEntity.ok(this.consultingAnswerService.read(principal, id));
    }

}
