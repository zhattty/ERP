package com.erp.web4j.mapper;

import com.erp.web4j.bean.FinalCountCheck;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface FinalCountCheckMapper {
    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCountCheck record);

    int insertSelective(FinalCountCheck record);

    FinalCountCheck selectByPrimaryKey(String fCountCheckId);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    int updateByPrimaryKey(FinalCountCheck record);

    int queryCount();

    ArrayList<FinalCountCheck> queryAllList(@Param("offset") Integer offset, @Param("rows") Integer rows);

    ArrayList<FinalCountCheck> queryListByCheckId(@Param("searchValue") String searchValue, @Param("offset") Integer offset, @Param("rows") Integer rows);

    int queryCountBycheckId(@Param("searchValue") String searchValue);

    int deleteByIds(@Param("ids") String[] ids);

    ArrayList<FinalCountCheck> queryListByOrderId(@Param("searchValue") String searchValue, @Param("offset")Integer offset, @Param("rows") Integer rows);

    int queryCountByOrderId(@Param("searchValue")String searchValue);
}