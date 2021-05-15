package com.dogfoot.insurancesystemserver.domain.user.service;

import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import com.dogfoot.insurancesystemserver.domain.user.dto.SignUpUserRequest;
import com.dogfoot.insurancesystemserver.domain.user.exception.EmailDuplicateException;
import com.dogfoot.insurancesystemserver.domain.user.exception.EmailNotVerifiedException;
import com.dogfoot.insurancesystemserver.domain.user.exception.UserExceptionMessage;
import com.dogfoot.insurancesystemserver.domain.user.repository.UserRepository;
import com.dogfoot.insurancesystemserver.global.mail.domain.EmailAuthCode;
import com.dogfoot.insurancesystemserver.global.mail.domain.EmailSubject;
import com.dogfoot.insurancesystemserver.global.mail.repository.EmailAuthCodeRepository;
import com.dogfoot.insurancesystemserver.global.mail.util.EmailAuthCodeGenerator;
import com.dogfoot.insurancesystemserver.global.mail.util.EmailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final EmailAuthCodeRepository emailAuthCodeRepository;
    private final UserRepository userRepository;
    private final EmailUtil emailUtil;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(SignUpUserRequest dto) {
        if (emailAuthCodeRepository.existsByEmail(dto.getEmail()))
            throw new EmailNotVerifiedException(UserExceptionMessage.EMAIL_NOT_VERIFIED_EXCEPTION_MESSAGE);
        if (userRepository.existsByEmail(dto.getEmail()))
            throw new EmailDuplicateException(UserExceptionMessage.EMAIL_DUPLICATE_EXCEPTION_MESSAGE);

        EmailAuthCodeGenerator authCodeGenerator = new EmailAuthCodeGenerator();
        String authCode = authCodeGenerator.generateAuthCode();
        emailAuthCodeRepository.save(EmailAuthCode.builder()
                .email(dto.getEmail())
                .authCode(authCode)
                .build());

        String message = emailUtil.getEmailAuthMessage(dto.getEmail(), authCode);
        emailUtil.sendEmail(dto.getEmail(), EmailSubject.EMAIL_AUTH_REQUEST, message);

        return userRepository.save(dto.toEntity(passwordEncoder));
    }
}
