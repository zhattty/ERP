package com.erp.web4j.mapper;

import com.erp.web4j.bean.Technology;
import com.erp.web4j.bean.TechnologyRequirement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyRequirementMapper {
    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateByPrimaryKeySelective(TechnologyRequirement record);

    int updateByPrimaryKey(TechnologyRequirement record);

    List<TechnologyRequirement> listOrders(@Param("offset") Integer offset,@Param("rows") Integer rows);

    Integer countOrderRecords();

    int deleteBatch(int[] ids);

    List<TechnologyRequirement> searchByName(@Param("searchValue") String searchValue,@Param("offset") Integer offset, @Param("rows")Integer rows);

    List<TechnologyRequirement> searchByPrimaryKey(@Param("searchValue") String searchValue,@Param("offset") Integer offset, @Param("rows")Integer rows);
}