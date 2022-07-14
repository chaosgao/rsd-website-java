package com.rsd.service;

import com.rsd.bean.NewsInfo;
import com.rsd.bean.NewsType;
import com.rsd.bean.SysUser;

import java.util.List;

public interface INewsInfoService {

    List<NewsInfo> queryList();

    NewsInfo getById(Integer id);

    void insert(NewsInfo newsInfo);

    void update(NewsInfo newsInfo);

    void delete(Integer id);

    List<NewsType> queryNewsTypeList();

    List<SysUser> querySysUserList();

}
