package com.rsd.controller;

import com.rsd.bean.SysFunction;
import com.rsd.service.ISysFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("sysFunction")
public class SysFunctionController {

    @Autowired
    private ISysFunctionService sysFunctionService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ModelAndView queryList(){
        ModelAndView modelAndView = new ModelAndView("/admin/jsp/sysFunction/list.jsp");
        List<SysFunction> list = sysFunctionService.queryList();

        modelAndView.addObject("list",list);
        return modelAndView;
    }

    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable Integer id){
        sysFunctionService.deleteById(id);

        return "redirect:/sysFunction/list";
    }

    @RequestMapping(value = "toUpdatePage/{id}",method = RequestMethod.GET)
    public ModelAndView toUpdatePage(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("/admin/jsp/sysFunction/update.jsp");
        SysFunction sysFunction = sysFunctionService.getById(id);

        modelAndView.addObject("sysFunction",sysFunction);

        return modelAndView;
    }

    @RequestMapping(value = "doUpdate",method = RequestMethod.POST)
    public String doUpdate(SysFunction sysFunction){
        sysFunctionService.update(sysFunction);

        return  "redirect:/sysFunction/list";
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String add(SysFunction sysFunction){
        sysFunctionService.insert(sysFunction);

        return  "redirect:/sysFunction/list";
    }
}
