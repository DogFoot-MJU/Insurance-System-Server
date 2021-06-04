package com.dogfoot.insurancesystemserver.domain.file.api;

import com.dogfoot.insurancesystemserver.domain.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RequiredArgsConstructor
@RestController
public class FileApi {

    private final FileService fileService;

    @PostMapping("file-save")
    public ResponseEntity<?> fileSave(@RequestPart MultipartFile files) throws Exception {
        fileService.save(files);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "api/v1/user/image/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> userSearch(@PathVariable String name) {
        try {
            InputStream imageStream = new FileInputStream(System.getProperty("user.dir") + "/images/" + name);
            byte[] imageByteArray = IOUtils.toByteArray(imageStream);
            imageStream.close();
            return new ResponseEntity<>(imageByteArray, HttpStatus.OK);
        } catch (IOException e) {
            throw new IllegalArgumentException("해당 파일을 찾을 수 업습니다.");
        }
    }

}
