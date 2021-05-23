package com.dogfoot.insurancesystemserver.domain.contract.dto;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import com.dogfoot.insurancesystemserver.domain.user.domain.User;

public abstract class ContractCreateRequest<T, U extends Insurance<?>> {

    public abstract Long getInsuranceId();

    public abstract T toEntity(User user, U u, Long payment);

}
