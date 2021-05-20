package com.dogfoot.insurancesystemserver.domain.capacitypolicy.api;

import com.dogfoot.insurancesystemserver.domain.capacitypolicy.dto.CapacityPolicyCreationRequest;
import com.dogfoot.insurancesystemserver.domain.capacitypolicy.dto.CapacityPolicyResponse;
import com.dogfoot.insurancesystemserver.domain.capacitypolicy.service.CapacityPolicyService;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/v1/uw/capacity")
@RestController
public class CapacityPolicyApiController {

    private final CapacityPolicyService capacityPolicyService;

    @PostMapping
    public ResponseEntity<DefaultResponseDto> create(@RequestBody CapacityPolicyCreationRequest dto) {
        this.capacityPolicyService.create(dto);
        return ResponseEntity.ok(DefaultResponseDto.from("인수정책 등록 완료"));
    }

    @GetMapping("list")
    public ResponseEntity<Pagination<List<CapacityPolicyResponse>>> list(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(this.capacityPolicyService.list(pageable));
    }

}
