package com.dogfoot.insurancesystemserver.domain.accident.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AccidentExceptionMessages {

    ACCIDENT_NOT_FOUND_EXCEPTION("해당 사고 접수 내역을 찾을 수 없습니다.");

    private final String message;

}
