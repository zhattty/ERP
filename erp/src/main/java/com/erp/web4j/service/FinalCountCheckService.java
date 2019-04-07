package com.erp.web4j.service;

import com.erp.web4j.bean.FinalCountCheck;

import java.util.ArrayList;

/**
 * Created by Yana
 * Date 2019/4/6 Time 23:40
 */
public interface FinalCountCheckService {
    int queryAllFinalCountCheckNumber();

    ArrayList<FinalCountCheck> queryAllFinalCountCheckList(Integer page, Integer rows);

    int insertFinalCountCheck(FinalCountCheck finalCountCheck);

    int updateFinalCountCheck(FinalCountCheck finalCountCheck);

    ArrayList<FinalCountCheck> queryFinalCountCheckListByCheckId(String searchValue, Integer page, Integer rows);

    int queryFinalCountCheckNumberByCheckId(String searchValue);

    int deleteByIds(String[] ids);

    ArrayList<FinalCountCheck> queryFinalCountCheckListByCOrderId(String searchValue, Integer page, Integer rows);

    int queryFinalCountCheckNumberByOrderId(String searchValue);
}
