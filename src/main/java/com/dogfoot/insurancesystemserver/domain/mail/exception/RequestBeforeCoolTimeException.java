package com.dogfoot.insurancesystemserver.domain.mail.exception;

public class RequestBeforeCoolTimeException extends IllegalArgumentException {

    public RequestBeforeCoolTimeException(String s) {
        super(s);
    }

}
