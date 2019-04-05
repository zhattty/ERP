package com.erp.web4j.mapper;

import com.erp.web4j.bean.Technology;
import com.erp.web4j.bean.TechnologyPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyPlanMapper {
    int deleteByPrimaryKey(String technologyPlanId);

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);

    Integer countOrderRecords();

    List<TechnologyPlan> listOrders(@Param("offset") Integer offset, @Param("rows") Integer rows);

    Integer deleteBatch(int[] ids);

    List<TechnologyPlan> searchByPrimaryKey(@Param("searchValue") String searchValue,@Param("offset") Integer offset, @Param("rows")Integer rows);

    List<TechnologyPlan> searchByName(@Param("searchValue") String searchValue,@Param("offset") Integer offset, @Param("rows")Integer rows);
}