package com.yesmadam.user_activities.util;

import com.yesmadam.user_activities.constants.ErrorMessageCodeConstante;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Getter
@Setter

public class BusinessException extends Exception {

    private String errorCode;
    private String message;

    public BusinessException() {
    }

    public BusinessException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public BusinessException(ErrorMessageCodeConstante errorMessageCode) {
        super(errorMessageCode.getMessage());
        this.errorCode = errorMessageCode.getErrorCode();
        this.message = errorMessageCode.getMessage();
    }

    public BusinessException(String message) {
        super(message);
        this.message = message;
    }
}
