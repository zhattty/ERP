package com.erp.web4j.service;

import com.erp.web4j.bean.ProcessMeasureCheck;

import java.util.ArrayList;

/**
 * Created by Yana
 * Date 2019/4/7 Time 17:31
 */
public interface ProcessMeasureCheckService {


    ArrayList<ProcessMeasureCheck> queryAllList(Integer page, Integer rows);

    int queryCount();


    int insert(ProcessMeasureCheck processMeasureCheck);

    int update(ProcessMeasureCheck processMeasureCheck);

    int deleteByIds(String[] ids);

    ArrayList<ProcessMeasureCheck> queryListByCheckId(String searchValue, Integer page, Integer rows);

    int queryNumberByCheckId(String searchValue);


}
