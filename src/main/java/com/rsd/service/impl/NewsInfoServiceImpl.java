package com.rsd.service.impl;

import com.rsd.bean.NewsInfo;
import com.rsd.bean.NewsType;
import com.rsd.bean.SysUser;
import com.rsd.dao.INewsInfoDAO;
import com.rsd.dao.INewsTypeDAO;
import com.rsd.dao.ISysUserDAO;
import com.rsd.service.INewsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsInfoServiceImpl implements INewsInfoService {

    @Autowired
    private INewsInfoDAO newsInfoDAO;

    @Autowired
    private INewsTypeDAO newsTypeDAO;

    @Autowired
    private ISysUserDAO sysUserDAO;

    @Override
    public List<NewsInfo> queryList() {
        return newsInfoDAO.queryList();
    }

    @Override
    public NewsInfo getById(Integer id) {
        return newsInfoDAO.getById(id);
    }

    @Override
    public void insert(NewsInfo newsInfo) {
        newsInfoDAO.insert(newsInfo);
    }

    @Override
    public void update(NewsInfo newsInfo) {
        newsInfoDAO.update(newsInfo);
    }

    @Override
    public void delete(Integer id) {
        newsInfoDAO.delete(id);
    }

    @Override
    public List<NewsType> queryNewsTypeList() {
        return newsTypeDAO.queryList();
    }

    @Override
    public List<SysUser> querySysUserList() {
        return sysUserDAO.queryList();
    }
}
