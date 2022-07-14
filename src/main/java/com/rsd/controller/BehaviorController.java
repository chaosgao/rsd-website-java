package com.rsd.controller;

import com.rsd.bean.Behavior;
import com.rsd.service.IBehaviorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("behavior")
public class BehaviorController {

    @Autowired
    private IBehaviorService behaviorService;

    @ResponseBody
    @GetMapping("list")
    public List<Behavior> queryList(){
        return behaviorService.queryList();
    }
}
