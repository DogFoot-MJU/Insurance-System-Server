package com.dogfoot.insurancesystemserver.domain.insurance.dto;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class InsuranceResponse {

    private final Long id;
    private final String name;

    public static InsuranceResponse from(Insurance carInsurance) {
        return new InsuranceResponse(carInsurance.getId(), carInsurance.getName());
    }

}
