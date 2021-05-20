package com.dogfoot.insurancesystemserver.domain.productdevelopment.exception;

public class DuplicateInsuranceNameException extends IllegalArgumentException {
    public DuplicateInsuranceNameException(String reason) {
        super(reason);
    }
}
