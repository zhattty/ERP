package com.erp.web4j.mapper;

import com.erp.web4j.bean.ProcessMeasureCheck;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface ProcessMeasureCheckMapper {
    int deleteByPrimaryKey(String pMeasureCheckId);

    int insert(ProcessMeasureCheck record);

    int insertSelective(ProcessMeasureCheck record);

    ProcessMeasureCheck selectByPrimaryKey(String pMeasureCheckId);

    int updateByPrimaryKeySelective(ProcessMeasureCheck record);

    int updateByPrimaryKey(ProcessMeasureCheck record);

    ArrayList<ProcessMeasureCheck> selectAllList(@Param("offset")Integer offset, @Param("rows")Integer rows);

    int queryCount();

    int deleteByIds(@Param("ids") String[] ids);

    ArrayList<ProcessMeasureCheck> queryCountByCheckId(@Param("searchValue") String searchValue, @Param("offset")Integer offset, @Param("rows")Integer rows);

    int queryCountNumberByCheckId(@Param("searchValue")String searchValue);

    ArrayList<ProcessMeasureCheck> queryListByOrderId(@Param("searchValue")String searchValue, @Param("offset")Integer offset, @Param("rows")Integer rows);

    int queryNumberByOrderId(@Param("searchValue")String searchValue);
}