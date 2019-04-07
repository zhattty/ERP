package com.erp.web4j.service;

import com.erp.web4j.bean.ProcessCountCheck;

import java.util.ArrayList;

/**
 * Created by Yana
 * Date 2019/4/7 Time 22:11
 */
public interface ProcessCountCheckService {
    ArrayList<ProcessCountCheck> queryAllList(Integer page, Integer rows);

    int queryCount();


    int insert(ProcessCountCheck processMeasureCheck);

    int update(ProcessCountCheck processMeasureCheck);

    int deleteByIds(String[] ids);

    ArrayList<ProcessCountCheck> queryListByCheckId(String searchValue, Integer page, Integer rows);

    int queryNumberByCheckId(String searchValue);

}
