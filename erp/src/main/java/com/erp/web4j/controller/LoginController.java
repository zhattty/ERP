package com.erp.web4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wawawa
 * Date 2019/4/3 Time 17:33
 * 这是一个初步的登录跳转的的Controller
 * 例如localhost/home
 */
@Controller
public class LoginController {
    @RequestMapping("/{pathName}")
    public String index(@PathVariable String pathName){
        return pathName;
    }

    @RequestMapping("*/*_judge")
    @ResponseBody
    public String jump_Judge(){
        return "{}";
    }
}
