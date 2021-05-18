package com.dogfoot.insurancesystemserver.domain.productdevelopment.exception;

import java.sql.SQLIntegrityConstraintViolationException;

public class DuplicateInsuranceNameException extends SQLIntegrityConstraintViolationException {
    public DuplicateInsuranceNameException(String reason) {
        super(reason);
    }
}
