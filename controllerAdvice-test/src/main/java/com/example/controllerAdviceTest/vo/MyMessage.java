package com.example.controllerAdviceTest.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MyMessage {

    int id;
    String message;

    public MyMessage(int id, String message) {
        this.id = id;
        this.message = message;
    }
}
