package com.dogfoot.insurancesystemserver.domain.consulting.dto;

import com.dogfoot.insurancesystemserver.domain.consulting.domain.Consulting;
import com.dogfoot.insurancesystemserver.domain.consulting.domain.ConsultingAnswer;
import com.dogfoot.insurancesystemserver.domain.user.domain.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ConsultingAnswerSaveRequest {

    @NotBlank(message = "상담 번호를 입력해주세요.")
    private Long consultingId;

    @Length(max = 65, message = "제목은 최대 65자까지 작성 가능합니다.")
    @NotBlank(message = "제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "내용을 입력해주세요.")
    private String contents;

    public ConsultingAnswer toEntity(Consulting consulting, User user) {
        return ConsultingAnswer.builder()
                .title(this.title)
                .contents(this.contents)
                .consulting(consulting)
                .user(user)
                .build();
    }

}
