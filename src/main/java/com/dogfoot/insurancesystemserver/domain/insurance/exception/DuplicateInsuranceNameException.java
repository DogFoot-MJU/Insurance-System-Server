package com.dogfoot.insurancesystemserver.domain.insurance.exception;

public class DuplicateInsuranceNameException extends IllegalArgumentException {
    public DuplicateInsuranceNameException(String reason) {
        super(reason);
    }
}
