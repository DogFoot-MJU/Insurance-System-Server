package com.dogfoot.insurancesystemserver.domain.contract.dto;

import com.dogfoot.insurancesystemserver.domain.contract.domain.Contract;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ContractResponse {
    private final Long contractId;
    private final String insuranceName;
    private final LocalDate expirationDate;

    public static ContractResponse from(Contract<?> contract) {
        return ContractResponse.builder()
                .contractId(contract.getId())
                .insuranceName(contract.getInsurance().getName())
                .expirationDate(contract.getExpirationDate())
                .build();
    }
}
