package com.erp.web4j.mapper;

import com.erp.web4j.bean.ProcessCountCheck;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface ProcessCountCheckMapper {
    int deleteByPrimaryKey(String pCountCheckId);

    int insert(ProcessCountCheck record);

    int insertSelective(ProcessCountCheck record);

    ProcessCountCheck selectByPrimaryKey(String pCountCheckId);

    int updateByPrimaryKeySelective(ProcessCountCheck record);

    int updateByPrimaryKey(ProcessCountCheck record);

    ArrayList<ProcessCountCheck> selectAllList(@Param("offset")Integer offset, @Param("rows")Integer rows);

    int queryCount();

    int deleteByIds(@Param("ids") String[] ids);

    ArrayList<ProcessCountCheck> queryCountByCheckId(@Param("searchValue") String searchValue, @Param("offset")Integer offset, @Param("rows")Integer rows);

    int queryCountNumberByCheckId(@Param("searchValue")String searchValue);
}