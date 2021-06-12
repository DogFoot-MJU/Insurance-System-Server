package com.dogfoot.insurancesystemserver.global.file.exception;

public class FileToSaveNotExistException extends IllegalArgumentException {

    public FileToSaveNotExistException(FileExceptionMessages m) {
        super(m.getMessage());
    }
}
