package com.yesmadam.user_activities.util;

import com.yesmadam.user_activities.constants.ErrorMessageCodeConstante;
import com.yesmadam.user_activities.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(value = {BusinessException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO setRuntimeException(BusinessException ex) {
        return ErrorResponseDTO.builder().message(ex.getMessage()).errorCode(ex.getErrorCode()).build();
    }

    @ExceptionHandler(value = {Throwable.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO setRuntimeException(Throwable ex) {
        ex.printStackTrace();
        return ErrorResponseDTO.builder().message(ErrorMessageCodeConstante.UNHANDLE_EXCEPTION.getMessage()).errorCode(ErrorMessageCodeConstante.UNHANDLE_EXCEPTION.getErrorCode()).build();
    }
}
