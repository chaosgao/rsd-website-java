package com.rsd.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rsd.bean.SysUser;
import com.rsd.mapper.ISysUserMapper;
import com.rsd.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private ISysUserMapper sysUserMapper;

    @Override
    public PageInfo<SysUser> queryList(Integer pageNum,Integer pageSize) {
        Page<SysUser> page = PageHelper.startPage(pageNum, pageSize);
        sysUserMapper.queryList();
        PageInfo<SysUser> PageInfo = new PageInfo(page);
        return PageInfo;
    }

    @Override
    public SysUser getById(Integer id) {
        return sysUserMapper.getById(id);
    }

    @Override
    public void deleteById(Integer id) {
        sysUserMapper.deleteById(id);
    }

    @Override
    public void update(SysUser sysUser) {
        sysUserMapper.update(sysUser);
    }

    @Override
    public void insert(SysUser sysUser) {
        sysUserMapper.insert(sysUser);
    }
}
