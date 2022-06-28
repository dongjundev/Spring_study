package com.example.controllerAdviceTest.mapper;

import com.example.controllerAdviceTest.vo.MyMessage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

    int insertTest(MyMessage message);
}
