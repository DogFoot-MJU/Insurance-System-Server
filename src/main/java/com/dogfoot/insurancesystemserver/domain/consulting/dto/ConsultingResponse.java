package com.dogfoot.insurancesystemserver.domain.consulting.dto;

import com.dogfoot.insurancesystemserver.domain.consulting.domain.Consulting;
import com.dogfoot.insurancesystemserver.domain.consulting.domain.ConsultingStateType;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ConsultingResponse {

    private final Long id;
    private final String title;
    private final String writer;
    private final ConsultingStateType state;
    private final Long answerId;
    private final LocalDate creationDate;

    public static ConsultingResponse from(Consulting consulting) {
        return ConsultingResponse.builder()
                .id(consulting.getId())
                .title(consulting.getTitle())
                .writer(consulting.getUser().getName())
                .state(consulting.getState())
                .answerId(consulting.getConsultingAnswer() == null ? -1L : consulting.getConsultingAnswer().getId())
                .creationDate(consulting.getCreatedDate().toLocalDateTime().toLocalDate())
                .build();
    }

}
