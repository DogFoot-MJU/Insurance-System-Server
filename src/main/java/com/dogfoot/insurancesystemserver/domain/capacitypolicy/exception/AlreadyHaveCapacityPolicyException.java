package com.dogfoot.insurancesystemserver.domain.capacitypolicy.exception;

public class AlreadyHaveCapacityPolicyException extends IllegalArgumentException {

    public AlreadyHaveCapacityPolicyException(CapacityPolicyExceptionMessages m) {
        super(m.getMessage());
    }

}
