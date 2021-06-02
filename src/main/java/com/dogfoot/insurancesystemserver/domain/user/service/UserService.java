package com.dogfoot.insurancesystemserver.domain.user.service;

import com.dogfoot.insurancesystemserver.domain.contract.dto.ContractResponse;
import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import com.dogfoot.insurancesystemserver.domain.user.dto.SignUpUserRequest;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;

import java.util.List;

public interface UserService {

    User saveUser(SignUpUserRequest dto);

    User findByEmail(String email);

    List<ContractResponse> findAllMyContract(PrincipalDetails principal);

}
