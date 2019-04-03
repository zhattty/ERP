package com.erp.web4j.mapper;

import com.erp.web4j.bean.FinalCountCheck;

public interface FinalCountCheckMapper {
    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCountCheck record);

    int insertSelective(FinalCountCheck record);

    FinalCountCheck selectByPrimaryKey(String fCountCheckId);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    int updateByPrimaryKey(FinalCountCheck record);
}