package com.rsd.service;

import com.rsd.bean.SysRole;

import java.util.List;

public interface ISysRoleService {

    List<SysRole> queryList();

    SysRole getById(Integer id);

    void deleteById(Integer id);

    void update(SysRole sysRole);

    void insert(SysRole sysRole);
}
