package com.example.delayqueuetest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobException extends Handler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map result(Exception exception) {
        String defaultMessage;
        defaultMessage = exception.getMessage();
        exception.printStackTrace();
        log.info("异常信息defaultMessage" + defaultMessage);
        return failResult(defaultMessage);
    }
}