package com.example.mybatis2.service;

import com.example.mybatis2.repository.MetaboxingMapper;
import com.example.mybatis2.vo.Metaboxing;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MetaboxingService {

    private final MetaboxingMapper metaboxingMapper;

    public List<Metaboxing> getAllMetaboxing() {
        return metaboxingMapper.findByAllMetaboxing();
    }
}
