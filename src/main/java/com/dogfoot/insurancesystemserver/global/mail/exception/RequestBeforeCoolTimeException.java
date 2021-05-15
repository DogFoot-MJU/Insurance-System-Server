package com.dogfoot.insurancesystemserver.global.mail.exception;

public class RequestBeforeCoolTimeException extends IllegalArgumentException {

    public RequestBeforeCoolTimeException(String s) {
        super(s);
    }

}
