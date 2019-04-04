package com.erp.web4j.service;

import com.erp.web4j.bean.SysUser;

/**
 * Created by ZhangYao
 * Date 2019/4/4 Time 11:00
 */
public interface SysUserService {
   SysUser selectSysUserByUsername(String username);
}
