package com.erp.web4j.service.impl;

import com.erp.web4j.bean.ProcessMeasureCheck;
import com.erp.web4j.mapper.ProcessMeasureCheckMapper;
import com.erp.web4j.service.ProcessMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Yana
 * Date 2019/4/7 Time 17:32
 */
@Service("processMeasureCheckService")
public class ProcessMeasureCheckServiceImpl implements ProcessMeasureCheckService {
    @Autowired
    ProcessMeasureCheckMapper processMeasureCheckMapper;

    @Override
    public ArrayList<ProcessMeasureCheck> queryAllList(Integer page, Integer rows) {
        return processMeasureCheckMapper.selectAllList((page-1)*rows, rows);
    }

    @Override
    public int queryCount() {
        return processMeasureCheckMapper.queryCount();
    }

    @Override
    public int insert(ProcessMeasureCheck processMeasureCheck) {
        return processMeasureCheckMapper.insertSelective(processMeasureCheck);
    }

    @Override
    public int update(ProcessMeasureCheck processMeasureCheck) {
        return processMeasureCheckMapper.updateByPrimaryKeySelective(processMeasureCheck);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return processMeasureCheckMapper.deleteByIds(ids);
    }

    @Override
    public ArrayList<ProcessMeasureCheck> queryListByCheckId(String searchValue, Integer page, Integer rows) {
        return processMeasureCheckMapper.queryCountByCheckId("%"+searchValue+"%", (page-1)*rows, rows);
    }

    @Override
    public int queryNumberByCheckId(String searchValue) {
        return processMeasureCheckMapper.queryCountNumberByCheckId("%"+searchValue+"%");
    }

}
