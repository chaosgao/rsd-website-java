package com.rsd.service;

import com.github.pagehelper.PageInfo;
import com.rsd.bean.SysUser;


public interface ISysUserService {

    PageInfo<SysUser> queryList(Integer pageNum,Integer pageSize);

    SysUser getById(Integer id);

    void deleteById(Integer id);

    void update(SysUser sysUser);

    void insert(SysUser sysUser);
}
