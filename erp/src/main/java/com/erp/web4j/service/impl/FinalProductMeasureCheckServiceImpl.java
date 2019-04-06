package com.erp.web4j.service.impl;

import com.erp.web4j.bean.FinalMeasuretCheck;
import com.erp.web4j.bean.ProcessMeasureCheck;
import com.erp.web4j.mapper.FinalMeasuretCheckMapper;
import com.erp.web4j.service.FinalProductMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Yana
 * Date 2019/4/5 Time 0:33
 */

@Service("measureCheckService")
public class FinalProductMeasureCheckServiceImpl implements FinalProductMeasureCheckService {

    @Autowired
    FinalMeasuretCheckMapper finalMeasuretCheckMapper;

    @Override
    public Integer queryMeasureCheckRecords() {
        return finalMeasuretCheckMapper.countMeasureCheckRecords();
    }

    @Override
    public ArrayList<ProcessMeasureCheck> queryMeasureCheck(Integer page, Integer rows) {
        return finalMeasuretCheckMapper.queryMeasureChecklist((page-1)*rows, rows);
    }

    @Override
    public int insert(FinalMeasuretCheck finalMeasuretCheck) {
        return  finalMeasuretCheckMapper.insertSelective(finalMeasuretCheck);

    }

    @Override
    public int update(FinalMeasuretCheck finalMeasuretCheck) {
        return finalMeasuretCheckMapper.updateByPrimaryKeySelective(finalMeasuretCheck);
    }

    @Override
    public int delete(String[] ids) {
        return  finalMeasuretCheckMapper.deleteByIds(ids);
    }

    @Override
    public ArrayList<FinalMeasuretCheck> finalMeasureCheckListById(String searchValue, Integer page, Integer rows) {
        return finalMeasuretCheckMapper.queryFinalMeasureCheckListById("%"+searchValue+"%", (page-1)*rows, rows);

    }

    @Override
    public int queryCountById(String searchValue, Integer page, Integer rows) {
        return finalMeasuretCheckMapper.queryCountById("%"+searchValue+"%", (page-1)*rows, rows);
    }

    @Override
    public ArrayList<FinalMeasuretCheck> finalMeasureCheckListByOrderId(String searchValue, Integer page, Integer rows) {
        return finalMeasuretCheckMapper.queryFinalMeasureCheckListByOrderId("%"+searchValue+"%", (page-1)*rows, rows);
    }

    @Override
    public int queryMeasureCheckRecordsByOrderId(String searchValue) {
        return finalMeasuretCheckMapper.queryCountByOrderId("%"+searchValue+"%");
    }
}
