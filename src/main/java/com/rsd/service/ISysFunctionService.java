package com.rsd.service;

import com.rsd.bean.SysFunction;
import com.rsd.bean.SysUser;

import java.util.List;

public interface ISysFunctionService {

    List<SysFunction> queryList();

    SysFunction getById(Integer id);

    void deleteById(Integer id);

    void update(SysFunction sysFunction);

    void insert(SysFunction sysFunction);

    void moreDelete(Integer id);

}
