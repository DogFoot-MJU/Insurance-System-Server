package com.dogfoot.insurancesystemserver.domain.productdevelopment.dto;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.DriverLicence;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DriverProductDesignRequest {

    @NotNull
    private Long id;

    @NotNull
    private LocalDate dateOfLicenseAcquisition;

    @NotNull
    private DriverLicence driverLicence;

}
