package com.dogfoot.insurancesystemserver.global.mail.service;

import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import com.dogfoot.insurancesystemserver.domain.user.domain.UserStateType;
import com.dogfoot.insurancesystemserver.domain.user.exception.EmailNotFoundException;
import com.dogfoot.insurancesystemserver.domain.user.exception.UserExceptionMessage;
import com.dogfoot.insurancesystemserver.domain.user.repository.UserRepository;
import com.dogfoot.insurancesystemserver.global.mail.domain.EmailAuthCode;
import com.dogfoot.insurancesystemserver.global.mail.repository.EmailAuthCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class EmailAuthService {

    private final EmailAuthCodeRepository emailAuthCodeRepository;
    private final UserRepository userRepository;

    @Transactional
    public void emailValidate(String email, String authCode) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException(UserExceptionMessage.EMAIL_NOT_FOUND_EXCEPTION_MESSAGE));
        if (user.getState().equals(UserStateType.NORMAL)) return;
        EmailAuthCode emailAuthCode = emailAuthCodeRepository.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException(UserExceptionMessage.EMAIL_NOT_FOUND_EXCEPTION_MESSAGE));

        emailAuthCode.validateCode(authCode);
        user.emailVerificationCompleted();
        emailAuthCodeRepository.delete(emailAuthCode);
    }

}
