package com.example.mybatis2.repository;

import com.example.mybatis2.vo.Metaboxing;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;
import java.util.List;

@Mapper
public interface MetaboxingMapper {

    List<Metaboxing> findByAllMetaboxing();
}
