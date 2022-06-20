package com.rsd.controller;

import com.rsd.bean.SysFunction;
import com.rsd.bean.SysUser;
import com.rsd.service.ISysFunctionService;
import com.rsd.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysFunctionService sysFunctionService;

    private ModelAndView modelAndView = new ModelAndView();

    @RequestMapping("h1")
    public String hi() {
        return "/jsp/test.jsp";
    }
    @RequestMapping("h2")
    public ModelAndView h2() {
        ModelAndView modelAndView = new ModelAndView("/jsp/test.jsp");

        modelAndView.addObject("name", "over--剋剋");
        return modelAndView;
    }
    @RequestMapping("h3")
    public ModelAndView h3() {
        modelAndView.addObject("name", "over--土豆");
        modelAndView.setViewName("/jsp/test.jsp");
        return modelAndView;
    }

    @RequestMapping("h4")
    public ModelAndView h4() {
//        List<SysUser> list = sysUserService.queryList();

//        modelAndView.addObject("list", list);
        modelAndView.setViewName("/jsp/test.jsp");
        return modelAndView;
    }

    @RequestMapping("h5")
    public ModelAndView h5(Integer id) {
        SysUser sysUser = sysUserService.getById(id);

        modelAndView.addObject("sysUser", sysUser);
        modelAndView.setViewName("/jsp/test.jsp");

        return modelAndView;
    }
    @RequestMapping("h6")
    public ModelAndView h6(Integer id,String sex) {

        modelAndView.addObject("id", id);
        modelAndView.addObject("sex", sex);
        modelAndView.setViewName("/jsp/test.jsp");

        return modelAndView;
    }

    @RequestMapping("h7")
    public ModelAndView h7(SysFunction sysFunction) {

        sysFunctionService.insert(sysFunction);

        modelAndView.setViewName("/jsp/test.jsp");

        return modelAndView;
    }
}
