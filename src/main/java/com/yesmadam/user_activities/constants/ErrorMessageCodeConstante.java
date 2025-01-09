package com.yesmadam.user_activities.constants;

import lombok.Getter;

@Getter
public enum ErrorMessageCodeConstante {
    NOT_FOUND("ERR-01","Data not Fount, Please Try again"),
    UNHANDLE_EXCEPTION("ERR-02","Sorry, Please Try again");
    private final String errorCode;
    private final String message;

    ErrorMessageCodeConstante(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
