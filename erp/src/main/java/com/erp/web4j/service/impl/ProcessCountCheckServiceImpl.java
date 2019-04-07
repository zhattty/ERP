package com.erp.web4j.service.impl;

import com.erp.web4j.bean.ProcessCountCheck;
import com.erp.web4j.mapper.ProcessCountCheckMapper;
import com.erp.web4j.service.ProcessCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Yana
 * Date 2019/4/7 Time 22:11
 */
@Service("processCountCheckService")
public class ProcessCountCheckServiceImpl implements ProcessCountCheckService {
    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;

    @Override
    public ArrayList<ProcessCountCheck> queryAllList(Integer page, Integer rows) {
        return processCountCheckMapper.selectAllList((page-1)*rows, rows);
    }

    @Override
    public int queryCount() {
        return processCountCheckMapper.queryCount();
    }

    @Override
    public int insert(ProcessCountCheck processMeasureCheck) {
        return processCountCheckMapper.insertSelective(processMeasureCheck);
    }

    @Override
    public int update(ProcessCountCheck processMeasureCheck) {
        return processCountCheckMapper.updateByPrimaryKeySelective(processMeasureCheck);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return processCountCheckMapper.deleteByIds(ids);
    }

    @Override
    public ArrayList<ProcessCountCheck> queryListByCheckId(String searchValue, Integer page, Integer rows) {
        return processCountCheckMapper.queryCountByCheckId("%"+searchValue+"%", (page-1)*rows, rows);
    }

    @Override
    public int queryNumberByCheckId(String searchValue) {
        return processCountCheckMapper.queryCountNumberByCheckId("%"+searchValue+"%");
    }

}
