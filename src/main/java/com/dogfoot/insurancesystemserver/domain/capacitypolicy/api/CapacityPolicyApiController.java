package com.dogfoot.insurancesystemserver.domain.capacitypolicy.api;

import com.dogfoot.insurancesystemserver.domain.capacitypolicy.dto.CapacityPolicyCreationRequest;
import com.dogfoot.insurancesystemserver.domain.capacitypolicy.service.CapacityPolicyService;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("api/v1/uw")
@RestController
public class CapacityPolicyApiController {

    private final CapacityPolicyService capacityPolicyService;

    @PostMapping("capacity")
    public ResponseEntity<DefaultResponseDto> create(@RequestBody CapacityPolicyCreationRequest dto) {
        this.capacityPolicyService.create(dto);
        return ResponseEntity.ok(DefaultResponseDto.from("인수정책 등록 완료"));
    }

}
