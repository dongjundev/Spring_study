package com.example.mybatis2.repository.pos;

import com.example.mybatis2.vo.Image;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.util.List;

@Mapper
public interface ImageMapper {

    List<Image> findByAllImage();
}
