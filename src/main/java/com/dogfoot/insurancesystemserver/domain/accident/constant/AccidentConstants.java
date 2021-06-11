package com.dogfoot.insurancesystemserver.domain.accident.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AccidentConstants {

    COMPLETE_ACCIDENT_RECEPTION("사고 접수 완료"),
    COMPLETE_COMPENSATION_PAID("보상 지급 완료"),
    REJECT_COMPENSATION("보상 지급을 거절했습니다");

    private final String message;

}
