package com.rsd.service.impl;

import com.rsd.bean.SysRole;
import com.rsd.mapper.ISysRoleMapper;
import com.rsd.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Autowired
    private ISysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> queryList() {
        return sysRoleMapper.queryList();
    }

    @Override
    public SysRole getById(Integer id) {
        return sysRoleMapper.getById(id);
    }

    @Override
    public void deleteById(Integer id) {
        sysRoleMapper.deleteById(id);
    }

    @Override
    public void update(SysRole sysRole) {
        sysRoleMapper.update(sysRole);
    }

    @Override
    public void insert(SysRole sysRole) {
        sysRoleMapper.insert(sysRole);
    }
}
