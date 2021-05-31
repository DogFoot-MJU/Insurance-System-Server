package com.dogfoot.insurancesystemserver.domain.user.api;

import com.dogfoot.insurancesystemserver.domain.contract.dto.ContractResponse;
import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import com.dogfoot.insurancesystemserver.domain.user.dto.SignUpUserRequest;
import com.dogfoot.insurancesystemserver.domain.user.dto.SignUpUserResponse;
import com.dogfoot.insurancesystemserver.domain.user.service.UserServiceImpl;
import com.dogfoot.insurancesystemserver.global.config.security.auth.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserServiceImpl userService;

    @PostMapping("signup")
    public ResponseEntity<SignUpUserResponse> signup(@Valid @RequestBody SignUpUserRequest dto) {
        User saved = userService.saveUser(dto);
        return ResponseEntity.ok(SignUpUserResponse.builder()
                .email(saved.getEmail())
                .message("해당 메일 주소로 이메일 인증 메일을 발송했습니다. 메일 인증을 하시면 회원가입이 완료됩니다.")
                .build());
    }

    @GetMapping("api/v1/user/my/contract")
    public ResponseEntity<List<ContractResponse>> findAllMyInsurance(@AuthenticationPrincipal PrincipalDetails principal) {
        return ResponseEntity.ok(this.userService.findAllMyContract(principal));
    }

}
