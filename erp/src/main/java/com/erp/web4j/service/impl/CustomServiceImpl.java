package com.erp.web4j.service.impl;

import com.erp.web4j.bean.Custom;
import com.erp.web4j.mapper.CustomMapper;
import com.erp.web4j.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/4 Time 13:59
 */
@Service
public class CustomServiceImpl implements CustomService {

    @Autowired
    CustomMapper customMapper;

    /**
     * 查询所有custom的信息
     * @return
     */
    @Override
    public List<Custom> listAllCustoms() {
        return customMapper.listAllCustoms();
    }

    @Override
    public Integer countAllCustomRecords() {
        return customMapper.countAllCustomRecords();
    }

    @Override
    public List<Custom> listAllCustomsWithPageAndRows(int page, int rows) {
        return customMapper.listAllCustomsWithOffsetAndLimit((page-1)*rows,rows);
    }

    @Override
    public int addCustom(Custom custom) {
        return customMapper.insertSelective(custom);
    }

    @Override
    public boolean checkCustomId(String customId) {
        return customMapper.countCustomById(customId) > 0;
    }

    @Override
    public int updateCustomById(Custom custom) {
        return customMapper.updateByPrimaryKeySelective(custom);
    }

    @Override
    public int deleteCustomByIds(String[] ids) {

        return customMapper.deleteByIds(ids);
    }

    @Override
    public List<Custom> listCustomsByCustomId(String searchValue, Integer page, Integer rows) {
        return customMapper.listCustomsByCustomId("%"+searchValue+"%", (page-1)*rows, rows);
    }

    @Override
    public Integer countCustomRecordsByCustomId(String searchValue) {
        return customMapper.countCustomRecordsByCustomId("%"+searchValue+"%");
    }

    @Override
    public List<Custom> listCustomsByCustomName(String searchValue, Integer page, Integer rows) {
        return customMapper.listCustomsByCustomName("%"+searchValue+"%", (page-1)*rows, rows);
    }

    @Override
    public Integer countCustomRecordsByCustomName(String searchValue) {
        return customMapper.countCustomRecordsByCustomName("%"+searchValue+"%");
    }

    @Override
    public Custom selectCustomByCustomId(String customId) {
        return customMapper.selectByPrimaryKey(customId);
    }
}
