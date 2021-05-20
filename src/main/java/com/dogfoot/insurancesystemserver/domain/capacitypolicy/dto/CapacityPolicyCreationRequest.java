package com.dogfoot.insurancesystemserver.domain.capacitypolicy.dto;

import com.dogfoot.insurancesystemserver.domain.capacitypolicy.domain.CapacityPolicy;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CapacityPolicyCreationRequest {

    private Long insuranceId;
    private String physical;
    private String economical;
    private String environmental;

    public CapacityPolicy toEntity() {
        return CapacityPolicy.builder()
                .physical(this.physical)
                .economical(this.economical)
                .environmental(this.environmental)
                .build();
    }

}
