package com.dogfoot.insurancesystemserver.domain.accident.api;

import com.dogfoot.insurancesystemserver.domain.accident.service.AccidentService;
import com.dogfoot.insurancesystemserver.global.dto.DefaultResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class AccidentApiController {

    private final AccidentService accidentService;

    @PostMapping("api/v1/user/accident/reception/{id}")
    public ResponseEntity<DefaultResponseDto> accidentReception(@RequestParam List<MultipartFile> files,
                                                                @PathVariable Long id) throws IOException {
        accidentService.save(files, id);
        return ResponseEntity.ok(DefaultResponseDto.from("사고 접수 완료."));
    }

}
