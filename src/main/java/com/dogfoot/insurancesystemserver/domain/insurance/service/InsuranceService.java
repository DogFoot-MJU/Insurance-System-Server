package com.dogfoot.insurancesystemserver.domain.insurance.service;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;

public interface InsuranceService {

    Insurance findById(Long id);

}
