package com.dogfoot.insurancesystemserver.domain.accident.exception;

public class AccidentNotFoundException extends IllegalArgumentException {

    public AccidentNotFoundException(AccidentExceptionMessages m) {
        super(m.getMessage());
    }

}
