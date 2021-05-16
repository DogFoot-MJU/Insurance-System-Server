package com.dogfoot.insurancesystemserver.domain.user.service;

import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import com.dogfoot.insurancesystemserver.domain.user.dto.SignUpUserRequest;

public interface UserService {

    User saveUser(SignUpUserRequest dto);

}
