package com.rsd.controller;

import com.rsd.bean.SysRole;
import com.rsd.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("sysRole")
public class SysRoleController {

    @Autowired
    private ISysRoleService sysRoleService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    private ModelAndView queryList(){
        ModelAndView modelAndView = new ModelAndView("/admin/jsp/sysRole/list.jsp");
        List<SysRole> list = sysRoleService.queryList();
        modelAndView.addObject("list",list);
        return modelAndView;
    }
    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    private String deleteById(@PathVariable Integer id){

        sysRoleService.deleteById(id);

        return "redirect:${pageContext.request.contextPath}/sysRole/list";
    }
    @RequestMapping(value = "toUpdatePage/{id}",method = RequestMethod.GET)
    private ModelAndView toUpdatePage(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("/admin/jsp/sysRole/update.jsp");
        SysRole sysRole = sysRoleService.getById(id);

        modelAndView.addObject("sysRole",sysRole);
        return modelAndView;
    }
    @RequestMapping(value = "doUpdate",method = RequestMethod.POST)
    private String doUpdate(SysRole sysRole){
        sysRoleService.update(sysRole);

        return "redirect:${pageContext.request.contextPath}/sysRole/list";
    }
    @RequestMapping(value = "add",method = RequestMethod.POST)
    private String add(SysRole sysRole){
        sysRoleService.insert(sysRole);

        return "redirect:${pageContext.request.contextPath}/sysRole/list";
    }
}
