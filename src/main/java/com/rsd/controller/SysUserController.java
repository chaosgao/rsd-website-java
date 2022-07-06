package com.rsd.controller;

import com.github.pagehelper.PageInfo;
import com.rsd.bean.SysRole;
import com.rsd.bean.SysUser;
import com.rsd.service.ISysRoleService;
import com.rsd.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("sysUser")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysRoleService sysRoleService;

    private Integer pageSize = 10;

    @RequestMapping(value = "list/{pageNum}",method = RequestMethod.GET)
    public ModelAndView list(@PathVariable Integer pageNum){
        ModelAndView modelAndView = new ModelAndView("/admin/jsp/sysUser/list.jsp");
        if (pageNum == null || pageNum.equals("")){
            pageNum=1;
        }
        PageInfo<SysUser> pageInfo = sysUserService.queryList(pageNum, pageSize);

        List<SysRole> sysRoleList = sysRoleService.queryList();
        modelAndView.addObject("sysRoleList",sysRoleList);
        modelAndView.addObject("pageInfo",pageInfo);

        return modelAndView;
    }
    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable Integer id){
        sysUserService.deleteById(id);

        return "redirect:/sysUser/list/1";
    }

    @RequestMapping(value = "doUpdate",method = RequestMethod.POST)
    public String doUpdate(SysUser sysUser){
        sysUserService.update(sysUser);

        return "redirect:/sysUser/list/1";
    }
    @RequestMapping(value = "toUpdatePage/{id}",method = RequestMethod.GET)
    public ModelAndView toUpdatePage(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("/admin/jsp/sysUser/update.jsp");
        SysUser sysUser = sysUserService.getById(id);
        List<SysRole> sysRoleList = sysRoleService.queryList();
        modelAndView.addObject("sysRoleList",sysRoleList);
        modelAndView.addObject("sysUser",sysUser);

        return modelAndView;
    }
    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insert(SysUser sysUser){
        sysUserService.insert(sysUser);

        return "redirect:/sysUser/list/1";
    }
    @RequestMapping(value = "toAddPage",method = RequestMethod.GET)
    public ModelAndView toAddPage(){
        ModelAndView modelAndView = new ModelAndView("/admin/jsp/sysUser/form.jsp");
        List<SysRole> sysRoleList = sysRoleService.queryList();
        modelAndView.addObject("sysRoleList",sysRoleList);
        return modelAndView;
    }
}
