package com.dogfoot.insurancesystemserver.domain.insurance.service;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.CarInsurance;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.CarInsuranceDetailResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.InsuranceResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.repository.InsuranceRepository;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CarInsuranceServiceImpl {

    private final InsuranceRepository<CarInsurance> insuranceRepository;
    private final InsuranceService<CarInsurance> insuranceService;

    public Pagination<List<InsuranceResponse>> listByAvailableSale(Pageable pageable) {
        Page<CarInsurance> page = this.insuranceRepository.findAllByIsAvailableSale(true, pageable);
        List<InsuranceResponse> data = page.getContent().stream().map(InsuranceResponse::from).collect(Collectors.toList());
        return Pagination.of(page, data);
    }

    public CarInsuranceDetailResponse read(Long id) {
        return CarInsuranceDetailResponse.from(this.insuranceService.findById(id));
    }
}
