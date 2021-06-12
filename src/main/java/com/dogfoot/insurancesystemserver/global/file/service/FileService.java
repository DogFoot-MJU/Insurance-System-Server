package com.dogfoot.insurancesystemserver.global.file.service;

import com.dogfoot.insurancesystemserver.global.file.dao.FileRepository;
import com.dogfoot.insurancesystemserver.global.file.exception.FileExceptionMessages;
import com.dogfoot.insurancesystemserver.global.file.exception.FileToSaveNotExistException;
import com.dogfoot.insurancesystemserver.global.file.file.MyFile;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import static com.dogfoot.insurancesystemserver.global.file.constant.FileConstants.BASE_DIR;
import static com.dogfoot.insurancesystemserver.global.file.constant.FileConstants.IMAGES_DIR;

@RequiredArgsConstructor
@Service
public class FileService {

    private final FileRepository fileRepository;

    public MyFile save(MultipartFile files) throws IOException {
        if (files.isEmpty()) throw new FileToSaveNotExistException(FileExceptionMessages.FILE_TO_SAVE_NOT_EXIST_EXCEPTION_MESSAGE);
        String originFilename = files.getOriginalFilename();
        String extension = FilenameUtils.getExtension(Objects.requireNonNull(originFilename)).toLowerCase();
        String path = System.getProperty(BASE_DIR) + "/" + IMAGES_DIR;
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
