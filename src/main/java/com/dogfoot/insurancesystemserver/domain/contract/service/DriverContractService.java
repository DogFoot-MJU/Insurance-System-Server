package com.dogfoot.insurancesystemserver.domain.contract.service;

import com.dogfoot.insurancesystemserver.domain.contract.domain.DriverContract;
import com.dogfoot.insurancesystemserver.domain.contract.dto.DriverContractCreateRequest;
import com.dogfoot.insurancesystemserver.domain.contract.dto.DriverContractResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.DriverInsurance;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.DriverLicence;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.DriverInsuranceDetailResponse;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;

@Service
public class DriverContractService extends
        ContractServiceImpl<DriverContract, DriverInsuranceDetailResponse, DriverInsurance,
                DriverContractCreateRequest, DriverContractResponse> {

    @Override
    public Long calculatePayment(DriverContractCreateRequest dto, DriverInsurance driverInsurance) {
        float rate = 1;
        DriverLicence driverLicence = dto.getDriverLicence();
        long day = Duration.between(dto.getDateOfLicenseAcquisition().atStartOfDay(), LocalDate.now().atStartOfDay()).toDays();
        long criteriaDay = Duration.between(driverInsurance.getDateOfLicenseAcquisition().atStartOfDay(), LocalDate.now().atStartOfDay()).toDays();
        if (driverLicence==DriverLicence.TYPE_1_NORMAL) rate += 0.1;
        else if (driverLicence.equals(DriverLicence.TYPE_2_NORMAL)) rate += 0.2;
        else rate += 0.3;
        if (day < criteriaDay + 365) rate += 0.1;
        else if (day < criteriaDay + 730) rate += 0.2;
        else if (day < criteriaDay+ 1095) rate += 0.3;
        else rate += 0.4;
        return (long) Math.round(driverInsurance.getPayment() * rate);
    }

    @Override
    public Specification<DriverContract> getUwDueProcessNoneSpecification() {
        return Specification.where(specification.equalToType("Driver").and(specification.equalUwDueProcessWait()));
    }
}
