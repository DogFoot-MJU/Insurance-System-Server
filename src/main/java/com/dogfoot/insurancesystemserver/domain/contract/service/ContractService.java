package com.dogfoot.insurancesystemserver.domain.contract.service;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import org.springframework.transaction.annotation.Transactional;

public interface ContractService<I extends Insurance, CreateReq> {

    @Transactional
    void create(PrincipalDetails principal, CreateReq dto);

    Long calculatePayment(CreateReq dto, I entity);

}
