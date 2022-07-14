package com.rsd.controller;

import com.rsd.bean.NewsInfo;
import com.rsd.bean.NewsType;
import com.rsd.bean.SysUser;
import com.rsd.service.INewsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("newsInfo")
public class NewsInfoController {

    @Autowired
    private INewsInfoService newsInfoService;

    @GetMapping("list")
    public List<NewsInfo> list(){
        return newsInfoService.queryList();
    }

    @GetMapping("newsTypeList")
    public List<NewsType> newsTypeList(){
        return newsInfoService.queryNewsTypeList();
    }

    @GetMapping("sysUserList")
    public List<SysUser> sysUserList(){
        return newsInfoService.querySysUserList();
    }

    @GetMapping("getById/{id}")
    public NewsInfo getById(@PathVariable Integer id){
        return newsInfoService.getById(id);
    }

    @PostMapping("insert")
    public void insert(NewsInfo newsInfo){
        newsInfoService.insert(newsInfo);
    }

    @PostMapping("update")
    public void update(NewsInfo newsInfo){
        newsInfoService.update(newsInfo);
    }

    @GetMapping("deleteById/{id}")
    public void delete(@PathVariable Integer id){
        newsInfoService.delete(id);
    }
}
