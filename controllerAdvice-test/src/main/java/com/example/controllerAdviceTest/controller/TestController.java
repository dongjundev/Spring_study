package com.example.controllerAdviceTest.controller;

import com.example.controllerAdviceTest.mapper.TestMapper;
import com.example.controllerAdviceTest.vo.MyMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final TestMapper testMapper;

    @PostMapping("/test1")
    public String normal() {
        log.info("서비스 진입!");
        return "normal 종료";
    }

    @PostMapping("/test2")
    public String error() {
        log.info("서비스 진입!");
        throw new RuntimeException("런타임 에러");
    }

    @PostMapping("/test3")
    @Transactional
    public String dbError() {
        log.info("서비스 진입!");
        MyMessage message = new MyMessage(2, "test");
        MyMessage message2 = new MyMessage(2, "test2");
        testMapper.insertTest(message);
        testMapper.insertTest(message2);
        return "dbError 종료";
    }
}
