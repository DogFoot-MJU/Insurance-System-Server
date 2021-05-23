package com.dogfoot.insurancesystemserver.domain.user.service;

import com.dogfoot.insurancesystemserver.domain.insurance.domain.Insurance;
import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import com.dogfoot.insurancesystemserver.domain.user.dto.SignUpUserRequest;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;

public interface UserService {

    User saveUser(SignUpUserRequest dto);

    User findByEmail(String email);

    Insurance findAllMyInsurance(PrincipalDetails principal);

}
