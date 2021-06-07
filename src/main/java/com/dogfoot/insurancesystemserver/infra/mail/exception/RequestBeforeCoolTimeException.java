package com.dogfoot.insurancesystemserver.infra.mail.exception;

public class RequestBeforeCoolTimeException extends IllegalArgumentException {

    public RequestBeforeCoolTimeException(String s) {
        super(s);
    }

}
