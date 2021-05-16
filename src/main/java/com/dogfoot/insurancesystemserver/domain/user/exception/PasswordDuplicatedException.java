package com.dogfoot.insurancesystemserver.domain.user.exception;

public class PasswordDuplicatedException extends IllegalArgumentException {

    public PasswordDuplicatedException(UserExceptionMessage m) {
        super(m.getMessage());
    }

}
