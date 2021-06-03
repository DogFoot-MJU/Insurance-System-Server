package com.dogfoot.insurancesystemserver.domain.user.dto;

import com.dogfoot.insurancesystemserver.domain.accident.domain.Accident;
import com.dogfoot.insurancesystemserver.domain.accident.domain.AccidentState;
import com.dogfoot.insurancesystemserver.domain.contract.domain.Contract;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AccidentResponse {

    private final Long accidentId;
    private final Long contractId;
    private final String insuranceName;
    private final String userName;
    private final AccidentState state;
    private final LocalDateTime accidentApplyDate;

    public static AccidentResponse of(Accident accident, Contract<?> contract) {
        return AccidentResponse.builder()
                .accidentId(accident.getId())
                .contractId(contract.getId())
                .insuranceName(contract.getInsurance().getName())
                .userName(contract.getUser().getName())
                .state(accident.getState())
                .accidentApplyDate(accident.getCreatedDate().toLocalDateTime())
                .build();
    }

}
