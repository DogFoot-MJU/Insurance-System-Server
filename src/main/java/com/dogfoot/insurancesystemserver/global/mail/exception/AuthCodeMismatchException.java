package com.dogfoot.insurancesystemserver.global.mail.exception;

public class AuthCodeMismatchException extends IllegalArgumentException{

    public AuthCodeMismatchException(EmailExceptionMessage m) {
        super(m.getMessage());
    }

}
