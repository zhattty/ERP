package com.erp.web4j.controller;

import com.erp.web4j.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ZhangYao
 * Date 2019/4/5 Time 10:09
 */
@Controller
@RequestMapping("work")
public class WorkController {
    @Autowired
    WorkService workService;

    @RequestMapping("find")
    public String findWorkList(){
        return "work_list";
    }

}
