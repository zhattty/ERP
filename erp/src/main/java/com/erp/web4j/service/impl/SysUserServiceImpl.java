package com.erp.web4j.service.impl;

import com.erp.web4j.bean.SysUser;
import com.erp.web4j.mapper.SysUserMapper;
import com.erp.web4j.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZhangYao
 * Date 2019/4/4 Time 11:40
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;

    /**
     * 通过用户名来查找user，可能返回null
     * @param username
     * @return
     */
    @Override
    public SysUser selectSysUserByUsername(String username) {
        return sysUserMapper.selectSysUserByUsername(username);
    }
}
