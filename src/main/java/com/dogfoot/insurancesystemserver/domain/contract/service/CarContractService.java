package com.dogfoot.insurancesystemserver.domain.contract.service;

import com.dogfoot.insurancesystemserver.domain.contract.domain.CarContract;
import com.dogfoot.insurancesystemserver.domain.contract.dto.CarContractCreateCreateRequest;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.CarInsurance;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.CarInsuranceDetailResponse;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;

@Service
public class CarContractService extends ContractServiceImpl<CarContract, CarInsuranceDetailResponse, CarInsurance, CarContractCreateCreateRequest> {

//    private final ContractRepository<CarContract> contractRepository;
//    private final InsuranceService<CarInsurance> insuranceService;
//    private final UserService userService;
//
//    public void create(PrincipalDetails principal, CarContractCreateCreateRequest dto) {
//        User user = userService.findByEmail(principal.getUsername());
//        CarInsurance insurance = insuranceService.findById(dto.getInsuranceId());
//        Long payment = calculatePayment(dto, insurance);
//        this.contractRepository.save(dto.toEntity(user, insurance, payment));
//    }

    @Override
    public Long calculatePayment(CarContractCreateCreateRequest dto, CarInsurance insurance) {
        float rate = 1;
        Long customerCarPrice = dto.getCustomerCarPrice();
        Long customerDrivingDistance = dto.getCustomerDrivingDistance();
        long day = Duration.between(dto.getCustomerCarReleaseDate().atStartOfDay(), LocalDate.now().atStartOfDay()).toDays();
        if (customerCarPrice < 20000000) rate += 0.1;
        else if (customerCarPrice < 50000000) rate += 0.2;
        else if (customerCarPrice < 100000000) rate += 0.3;
        else rate += 0.4;
        if (customerDrivingDistance < 10000) rate += 0.1;
        else if (customerDrivingDistance < 50000) rate += 0.2;
        else if (customerDrivingDistance < 100000) rate += 0.3;
        else rate += 0.4;
        if (day < 730) rate += 0.1;
        else if (day < 1460) rate += 0.2;
        else if (day < 2190) rate += 0.3;
        else if (day < 2920) rate += 0.4;
        else rate += 0.5;
        return (long) Math.round(insurance.getPayment() * rate);
    }

}