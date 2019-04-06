package com.erp.web4j.mapper;

import com.erp.web4j.bean.FinalMeasuretCheck;
import com.erp.web4j.bean.ProcessMeasureCheck;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface FinalMeasuretCheckMapper {
    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(FinalMeasuretCheck record);

    int insertSelective(FinalMeasuretCheck record);

    FinalMeasuretCheck selectByPrimaryKey(String fMeasureCheckId);

    int updateByPrimaryKeySelective(FinalMeasuretCheck record);

    int updateByPrimaryKey(FinalMeasuretCheck record);

    Integer countMeasureCheckRecords();

    ArrayList<ProcessMeasureCheck> queryMeasureChecklist(@Param("offset") Integer offset, @Param("rows") Integer rows);

    int deleteByIds(@Param("ids") String[] ids);


    int queryCountById(@Param("searchValue") String searchValue,@Param("offset") Integer offset, @Param("rows") Integer rows);

    ArrayList<FinalMeasuretCheck> queryFinalMeasureCheckListById(@Param("searchValue") String searchValue, @Param("offset")Integer offset, @Param("rows") Integer rows);

    ArrayList<FinalMeasuretCheck> queryFinalMeasureCheckListByOrderId(@Param("searchValue")String searchValue, @Param("offset") Integer offset, @Param("rows") Integer rows);

    int queryCountByOrderId(@Param("searchValue") String searchValue);
}