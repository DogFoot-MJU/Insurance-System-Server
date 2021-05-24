package com.dogfoot.insurancesystemserver.domain.contract.service;

import com.dogfoot.insurancesystemserver.domain.contract.domain.Contract;
import com.dogfoot.insurancesystemserver.domain.contract.dto.CalculatePaymentResponse;
import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import com.dogfoot.insurancesystemserver.global.dto.Pagination;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ContractService<I extends Insurance, CreateReq, Res, C extends Contract<Res>> {

    @Transactional
    void create(PrincipalDetails principal, CreateReq dto);

    CalculatePaymentResponse calculateRequest(PrincipalDetails principal, CreateReq dto);

    Long calculatePayment(CreateReq dto, I entity);

    @Transactional
    Pagination<List<Res>> dueProcessWaitList(Pageable pageable);

    Specification<C> getUwDueProcessNoneSpecification();

    Res read(PrincipalDetails principal, Long id);

    Contract<Res> findById(Long id);

}
