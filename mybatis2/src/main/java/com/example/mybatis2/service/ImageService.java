package com.example.mybatis2.service;

import com.example.mybatis2.repository.pos.ImageMapper;
import com.example.mybatis2.vo.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageMapper imageMapper;

    public List<Image> getAllImage() {
        return imageMapper.findByAllImage();
    }
}
