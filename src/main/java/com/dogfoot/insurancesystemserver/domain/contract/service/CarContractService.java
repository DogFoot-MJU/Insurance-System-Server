package com.dogfoot.insurancesystemserver.domain.contract.service;

import com.dogfoot.insurancesystemserver.domain.contract.domain.CarContract;
import com.dogfoot.insurancesystemserver.domain.contract.dto.CarContractCreateRequest;
import com.dogfoot.insurancesystemserver.domain.contract.dto.CarContractResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.CarInsurance;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.CarInsuranceDetailResponse;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;

@Service
public class CarContractService extends
        ContractServiceImpl<CarContract, CarInsuranceDetailResponse, CarInsurance,
                CarContractCreateRequest, CarContractResponse> {

    @Override
    public Long calculatePayment(CarContractCreateRequest dto, CarInsurance insurance) {
        float rate = 1;
        Long customerCarPrice = dto.getCustomerCarPrice();
        Long customerDrivingDistance = dto.getCustomerDrivingDistance();
        long day = Duration.between(dto.getCustomerCarReleaseDate().atStartOfDay(), LocalDate.now().atStartOfDay()).toDays();
        long criteriaDay = Duration.between(insurance.getCarReleaseDate().atStartOfDay(), LocalDate.now().atStartOfDay()).toDays();
        if (customerCarPrice < insurance.getCarPrice() - 20000000) rate += 0.1;
        else if (customerCarPrice < insurance.getCarPrice()) rate += 0.2;
        else if (customerCarPrice < insurance.getCarPrice() + 50000000) rate += 0.3;
        else rate += 0.4;
        if (customerDrivingDistance < insurance.getDrivingDistance() - 10000) rate += 0.1;
        else if (customerDrivingDistance < insurance.getDrivingDistance()) rate += 0.2;
        else if (customerDrivingDistance < insurance.getDrivingDistance() + 100000) rate += 0.3;
        else rate += 0.4;
        if (day < criteriaDay-730) rate += 0.1;
        else if (day < criteriaDay) rate += 0.2;
        else if (day < criteriaDay+730) rate += 0.3;
        else rate += 0.4;
        return (long) Math.round(insurance.getPayment() * rate);
    }

    @Override
    public Specification<CarContract> getUwDueProcessNoneSpecification() {
        return Specification.where(specification.equalToType("Car").and(specification.equalUwDueProcessWait()));
    }
}