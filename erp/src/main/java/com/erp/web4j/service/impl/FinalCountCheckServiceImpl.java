package com.erp.web4j.service.impl;

import com.erp.web4j.bean.FinalCountCheck;
import com.erp.web4j.mapper.FinalCountCheckMapper;
import com.erp.web4j.service.FinalCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Yana
 * Date 2019/4/6 Time 23:41
 */
@Service("finalCountCheckService")
public class FinalCountCheckServiceImpl implements FinalCountCheckService {
    @Autowired
    FinalCountCheckMapper finalCountCheckMapper;

    @Override
    public int queryAllFinalCountCheckNumber() {
        return finalCountCheckMapper.queryCount();
    }

    @Override
    public ArrayList<FinalCountCheck> queryAllFinalCountCheckList(Integer page, Integer rows) {
        return finalCountCheckMapper.queryAllList((page-1)*rows, rows);
    }

    @Override
    public int insertFinalCountCheck(FinalCountCheck finalCountCheck) {
        return finalCountCheckMapper.insertSelective(finalCountCheck);
    }

    @Override
    public int updateFinalCountCheck(FinalCountCheck finalCountCheck) {
        return finalCountCheckMapper.updateByPrimaryKeySelective(finalCountCheck);
    }

    @Override
    public ArrayList<FinalCountCheck> queryFinalCountCheckListByCheckId(String searchValue, Integer page, Integer rows) {
        return finalCountCheckMapper.queryListByCheckId("%"+searchValue+"%", (page-1)*rows, rows);
    }

    @Override
    public int queryFinalCountCheckNumberByCheckId(String searchValue) {
        return finalCountCheckMapper.queryCountBycheckId(searchValue);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return finalCountCheckMapper.deleteByIds(ids);
    }

    @Override
    public ArrayList<FinalCountCheck> queryFinalCountCheckListByCOrderId(String searchValue, Integer page, Integer rows) {
        return finalCountCheckMapper.queryListByOrderId(searchValue,(page-1)*rows, rows);
    }

    @Override
    public int queryFinalCountCheckNumberByOrderId(String searchValue) {
        return finalCountCheckMapper.queryCountByOrderId("%"+searchValue+"%");
    }
}
