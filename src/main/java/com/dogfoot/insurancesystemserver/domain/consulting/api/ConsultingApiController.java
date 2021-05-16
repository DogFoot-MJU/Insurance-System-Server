package com.dogfoot.insurancesystemserver.domain.consulting.api;

import com.dogfoot.insurancesystemserver.domain.consulting.dto.ConsultingCreateRequest;
import com.dogfoot.insurancesystemserver.domain.consulting.dto.ConsultingResponse;
import com.dogfoot.insurancesystemserver.domain.consulting.service.ConsultingService;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("user/consulting/list")
    public ResponseEntity<Pagination<List<ConsultingResponse>>> readAllForUser(
            @PageableDefault(sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable,
            @AuthenticationPrincipal PrincipalDetails principal) {
        return this.consultingService.readAllForUser(pageable, principal);
    }

}
