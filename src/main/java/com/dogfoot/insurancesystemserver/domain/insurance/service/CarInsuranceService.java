package com.dogfoot.insurancesystemserver.domain.insurance.service;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.CarInsurance;
import com.dogfoot.insurancesystemserver.domain.insurance.dto.CarInsuranceDetailResponse;
import com.dogfoot.insurancesystemserver.global.util.ListSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CarInsuranceService extends InsuranceServiceImpl<CarInsuranceDetailResponse, CarInsurance> {

    private final ListSpecification<CarInsurance> specification;
//    private final InsuranceRepository<CarInsurance> insuranceRepository;
//    private final InsuranceService<CarInsurance> insuranceService;

//    public Pagination<List<InsuranceResponse>> listByAvailableSale(Pageable pageable) {
//        Page<CarInsurance> page = this.insuranceRepository.findAllByIsAvailableSale(true, pageable);
//        List<InsuranceResponse> data = page.getContent().stream().map(InsuranceResponse::from).collect(Collectors.toList());
//        return Pagination.of(page, data);
//    }

//    public CarInsuranceDetailResponse read(Long id) {
//        return this.insuranceService.findById(id).toDetailResponse();
//    }

    @Override
    public Specification<CarInsurance> getSpecification() {
        return specification.equalToType("Car").and(specification.equalToIsAvailableTrue());
    }
}
