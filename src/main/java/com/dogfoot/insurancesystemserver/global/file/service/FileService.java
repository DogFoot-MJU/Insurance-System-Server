package com.dogfoot.insurancesystemserver.global.file.service;

import com.dogfoot.insurancesystemserver.global.file.file.MyFile;
import com.dogfoot.insurancesystemserver.global.file.dao.FileRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FileService {

    private final FileRepository fileRepository;

    public MyFile save(MultipartFile files) throws IOException {
        if (files.isEmpty()) throw new IllegalArgumentException("파일이 존재하지 않습니다.");
        String originFilename = files.getOriginalFilename();
        String extension = FilenameUtils.getExtension(Objects.requireNonNull(originFilename)).toLowerCase();
        String path = System.getProperty("user.dir") + "/images/";
        File saveFile;
        String fileName;
        do {
            fileName = UUID.randomUUID() + "." + extension;
            saveFile = new File(path + fileName);
        } while (saveFile.exists());
        saveFile.mkdirs();
        files.transferTo(saveFile);
        return fileRepository.save(MyFile.builder()
                .filename(fileName)
                .fileOriginName(originFilename)
                .fileUrl(path)
                .build());
    }
}
