package com.dogfoot.insurancesystemserver.domain.insurance.dto;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.CarInsurance;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CarInsuranceResponse {

    private final Long id;
    private final String name;

    public static CarInsuranceResponse from(CarInsurance carInsurance) {
        return new CarInsuranceResponse(carInsurance.getId(), carInsurance.getName());
    }

}
