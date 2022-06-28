package com.example.controllerAdviceTest.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(Exception.class)
    public String errorCatch(Exception e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        log.info("ControllerAdvice 작동!");
        log.info("e.getMessage(): {}",e.getMessage());
        log.info("------------------------------ControllerAdvice out // {}", request.getRequestURL());

        return "ControllerAdvice 종료";
    }
}
