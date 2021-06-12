package com.dogfoot.insurancesystemserver.domain.compensation.service;

import com.dogfoot.insurancesystemserver.domain.compensation.dto.CompensationApproveRequest;

public interface CompensationService {

    void compensationApprove(CompensationApproveRequest request);

    void compensationReject(Long id);

}
