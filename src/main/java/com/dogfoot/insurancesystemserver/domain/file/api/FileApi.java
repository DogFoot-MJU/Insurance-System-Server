package com.dogfoot.insurancesystemserver.domain.file.api;

import com.dogfoot.insurancesystemserver.domain.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
public class FileApi {

    private final FileService fileService;

    @PostMapping("file-save")
    public ResponseEntity<?> fileSave(@RequestPart MultipartFile files) throws Exception {
        fileService.save(files);
        return ResponseEntity.ok(null);
    }

}
