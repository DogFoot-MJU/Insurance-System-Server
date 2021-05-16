package com.dogfoot.insurancesystemserver.domain.consulting.dto;

import com.dogfoot.insurancesystemserver.domain.consulting.domain.Consulting;
import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
public class ConsultingCreateRequest {

    @Length(max = 65, message = "제목은 최대 65자까지 작성 가능합니다.")
    @NotBlank(message = "제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "내용을 입력해주세요.")
    private String contents;

    public Consulting toEntity(User user) {
        return Consulting.builder()
                .title(this.title)
                .contents(this.contents)
                .user(user)
                .build();
    }

}
