package com.rsd.service.impl;

import com.rsd.bean.SysFunction;
import com.rsd.mapper.ISysFunctionMapper;
import com.rsd.service.ISysFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysFunctionServiceImpl implements ISysFunctionService {

    @Autowired
    private ISysFunctionMapper sysFunctionMapper;

    @Override
    public List<SysFunction> queryList() {
        return sysFunctionMapper.queryList();
    }

    @Override
    public SysFunction getById(Integer id) {
        return sysFunctionMapper.getById(id);
    }

    @Override
    public void deleteById(Integer id) {
        sysFunctionMapper.deleteById(id);
    }

    @Override
    public void update(SysFunction sysFunction) {
        sysFunctionMapper.update(sysFunction);
    }

    @Override
    public void insert(SysFunction sysFunction) {
        sysFunctionMapper.insert(sysFunction);
    }

    @Override
    @Transactional
    public void moreDelete(Integer id) {
        sysFunctionMapper.deleteById(id);
//        int i = 5 / 0;

        sysFunctionMapper.deleteById(id + 1);
    }
}
