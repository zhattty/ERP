package com.erp.web4j.controller;

import com.erp.web4j.bean.Msg;
import com.erp.web4j.bean.SysUser;
import com.erp.web4j.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by ZhangYao
 * Date 2019/4/4 Time 10:31
 */
@Controller
public class AjaxController {

    @Autowired
    SysUserService sysUserService;

    @RequestMapping("ajaxLogin")
    @ResponseBody
    public Msg ajaxLogin(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         String randomcode,
                         HttpServletRequest request){
        Msg msg = new Msg();
        HttpSession session = request.getSession();
        String validateCode = (String) session.getAttribute("validateCode");
        if (validateCode != null){
            if (!validateCode.equals(randomcode)){
                msg.setMsg("authentication_error");
                return msg;
            }
        }
        SysUser sysUser = sysUserService.selectSysUserByUsername(username);
        if (sysUser == null){

            msg.setMsg("account_error");
            return msg;
        }
        if (!sysUser.getUsername().equals(password)){
            msg.setMsg("password_error");
            return msg;
        }else if(!"1".equals(sysUser.getLocked())){
            msg.setMsg("authentication_error");
            return msg;
        }else {
            sysUser.setRolename("超级管理员");
            session.setAttribute("activeUser",sysUser);
            msg.setMsg("success");
        }
        return msg;
    }
    @RequestMapping("logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";
    }
}
