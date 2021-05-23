package com.dogfoot.insurancesystemserver.domain.contract.service;

import com.dogfoot.insurancesystemserver.domain.contract.domain.Contract;
import com.dogfoot.insurancesystemserver.domain.contract.dto.ContractCreateRequest;
import com.dogfoot.insurancesystemserver.domain.contract.repository.ContractRepository;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import com.dogfoot.insurancesystemserver.domain.insurance.service.InsuranceService;
import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import com.dogfoot.insurancesystemserver.domain.user.service.UserService;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class ContractServiceImpl<C extends Contract, DetailRes, I extends Insurance<DetailRes>, CreateReq extends ContractCreateRequest<C, I>>
        implements ContractService<I, CreateReq>{

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ContractRepository<C> contractRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private InsuranceService<DetailRes, I> insuranceService;

    @Autowired
    private UserService userService;

    @Override
    public void create(PrincipalDetails principal, CreateReq dto) {
        User user = userService.findByEmail(principal.getUsername());
        I insurance = insuranceService.findById(dto.getInsuranceId());
        Long payment = calculatePayment(dto, insurance);
        this.contractRepository.save(dto.toEntity(user, insurance, payment));
    }

}
