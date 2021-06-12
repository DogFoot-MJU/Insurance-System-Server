package com.dogfoot.insurancesystemserver.domain.contract.service;

import com.dogfoot.insurancesystemserver.domain.contract.domain.Contract;
import com.dogfoot.insurancesystemserver.domain.contract.dto.CalculatePaymentResponse;
import com.dogfoot.insurancesystemserver.domain.contract.dto.ContractCreateRequest;
import com.dogfoot.insurancesystemserver.domain.contract.dao.ContractRepository;
import com.dogfoot.insurancesystemserver.domain.contract.exception.ContractExceptionMessages;
import com.dogfoot.insurancesystemserver.domain.contract.exception.ContractNotFoundException;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import com.dogfoot.insurancesystemserver.domain.insurance.service.InsuranceService;
import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import com.dogfoot.insurancesystemserver.domain.user.service.UserService;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import com.dogfoot.insurancesystemserver.global.dto.PaginationDto;
import com.dogfoot.insurancesystemserver.global.util.ListSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Component
public abstract class ContractServiceImpl<C extends Contract<Res>, DetailRes, I extends Insurance,
        CreateReq extends ContractCreateRequest<C, I>, Res> implements ContractService<I, CreateReq, Res, C>{

    @Autowired
    private ContractRepository<C> contractRepository;

    @Autowired
    private InsuranceService<DetailRes, I> insuranceService;

    @Autowired
    private UserService userService;

    @Autowired
    protected ListSpecification<C> specification;

    @Override
    public void create(PrincipalDetails principal, CreateReq dto) {
        User user = userService.findByEmail(principal.getUsername());
        I insurance = insuranceService.findById(dto.getInsuranceId());
        Long payment = calculatePayment(dto, insurance);
        this.contractRepository.save(dto.toEntity(user, insurance, payment));
    }

    @Override
    public CalculatePaymentResponse calculateRequest(PrincipalDetails principal, CreateReq dto) {
        I insurance = insuranceService.findById(dto.getInsuranceId());
        return CalculatePaymentResponse.from(calculatePayment(dto, insurance));
    }

    @Override
    public PaginationDto<List<Res>> dueProcessWaitList(Pageable pageable) {
        Page<C> page = contractRepository.findAll(getUwDueProcessNoneSpecification(), pageable);
        List<Res> data = page.get().map(Contract::toResponse).collect(Collectors.toList());
        return PaginationDto.of(page, data);
    }

    @Override
    public Res read(PrincipalDetails principal, Long id) {
        return findById(id).toResponse();
    }

    @Override
    public void uwApprove(PrincipalDetails principal, Long id) {
        findById(id).uwDueProcessApprove();
    }

    @Override
    public void uwReject(PrincipalDetails principal, Long id) {
        findById(id).uwDueProcessReject();
    }

    @Override
    public Contract<Res> findById(Long id) {
        return contractRepository.findById(id).orElseThrow(() -> new ContractNotFoundException(ContractExceptionMessages.CONTRACT_NOT_FOUND_EXCEPTION));
    }
}
