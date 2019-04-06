package com.erp.web4j.service;

import com.erp.web4j.bean.FinalMeasuretCheck;
import com.erp.web4j.bean.ProcessMeasureCheck;

import java.util.ArrayList;

/**
 * Created by Yana
 * Date 2019/4/5 Time 0:33
 */


public interface FinalProductMeasureCheckService {
    Integer queryMeasureCheckRecords();

    ArrayList<ProcessMeasureCheck> queryMeasureCheck(Integer page, Integer rows);

    int insert(FinalMeasuretCheck finalMeasuretCheck);

    int update(FinalMeasuretCheck finalMeasuretCheck);

    int delete(String[] ids);

    ArrayList<FinalMeasuretCheck> finalMeasureCheckListById(String searchValue, Integer page, Integer rows);

    int queryCountById(String searchValue, Integer page, Integer rows);

    ArrayList<FinalMeasuretCheck> finalMeasureCheckListByOrderId(String searchValue, Integer page, Integer rows);

    int queryMeasureCheckRecordsByOrderId(String searchValue);
}
