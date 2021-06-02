package com.dogfoot.insurancesystemserver.domain.consulting.service;

import com.dogfoot.insurancesystemserver.domain.consulting.domain.Consulting;
import com.dogfoot.insurancesystemserver.domain.consulting.domain.ConsultingAnswer;
import com.dogfoot.insurancesystemserver.domain.consulting.domain.ConsultingStateType;
import com.dogfoot.insurancesystemserver.domain.consulting.dto.ConsultingAnswerResponse;
import com.dogfoot.insurancesystemserver.domain.consulting.dto.ConsultingAnswerSaveRequest;
import com.dogfoot.insurancesystemserver.domain.consulting.repository.ConsultingAnswerRepository;
import com.dogfoot.insurancesystemserver.domain.consulting.repository.ConsultingRepository;
import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import com.dogfoot.insurancesystemserver.domain.user.domain.UserRoleType;
import com.dogfoot.insurancesystemserver.domain.user.exception.UserExceptionMessage;
import com.dogfoot.insurancesystemserver.domain.user.repository.UserRepository;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ConsultingAnswerServiceImpl implements ConsultingAnswerService {

    private final UserRepository userRepository;
    private final ConsultingRepository consultingRepository;
    private final ConsultingAnswerRepository consultingAnswerRepository;

    @Override
    public void create(PrincipalDetails principal, ConsultingAnswerSaveRequest dto) {
        Consulting consulting = consultingRepository.findById(dto.getConsultingId())
                .orElseThrow(() -> new IllegalArgumentException("해당 상담이 존재하지 않습니다."));
        if (consulting.getState().equals(ConsultingStateType.COMPLETE))
            throw new IllegalArgumentException("해당 상담은 이미 답변이 완료되었습니다.");
        User user = this.userRepository.findById(principal.toEntity().getId())
                .orElseThrow(() -> new UsernameNotFoundException(UserExceptionMessage.USERNAME_NOT_FOUND_EXCEPTION_MESSAGE.getMessage()));
        ConsultingAnswer answer = consultingAnswerRepository.save(dto.toEntity(consulting, user));
        consulting.answer(answer);
    }

    @Override
    public ConsultingAnswerResponse read(PrincipalDetails principal, Long id) {
        ConsultingAnswer answer = this.consultingAnswerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 답변이 존재하지 않습니다."));
        if (principal.toEntity().getRole().equals(UserRoleType.ROLE_INSURANCE_SELLER) ||
                principal.toEntity().getRole().equals(UserRoleType.ROLE_ADMIN)) {
            return ConsultingAnswerResponse.from(answer);
        }
        if (!principal.getUsername().equals(answer.getConsulting().getUser().getEmail()))
            throw new IllegalArgumentException("해당 접근 권한이 없습니다.");
        return ConsultingAnswerResponse.from(answer);
    }
}
