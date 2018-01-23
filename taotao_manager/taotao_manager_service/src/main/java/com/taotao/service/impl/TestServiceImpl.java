package com.taotao.service.impl;

import com.taobao.service.TestService;
import com.taotao.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;
    @Override
    public String getNow() {
        return testMapper.getNow();
    }
}
