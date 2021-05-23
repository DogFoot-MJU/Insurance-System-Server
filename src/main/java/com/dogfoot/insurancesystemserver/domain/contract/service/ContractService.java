package com.dogfoot.insurancesystemserver.domain.contract.service;

import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;

public interface ContractService<Insurance, CreateReq> {

    void create(PrincipalDetails principal, CreateReq dto);

    Long calculatePayment(CreateReq dto, Insurance entity);

}
