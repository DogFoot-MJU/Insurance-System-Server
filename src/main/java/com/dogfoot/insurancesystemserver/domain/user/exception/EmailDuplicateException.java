package com.dogfoot.insurancesystemserver.domain.user.exception;

public class EmailDuplicateException extends IllegalArgumentException {

    public EmailDuplicateException(UserExceptionMessage m) {
        super(m.getMessage());
    }

}
