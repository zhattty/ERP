package com.erp.web4j.mapper;

import com.erp.web4j.bean.Technology;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyMapper {
    int deleteByPrimaryKey(String technologyId);

    int insert(Technology record);

    int insertSelective(Technology record);

    Technology selectByPrimaryKey(String technologyId);

    int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);

    List<Technology> findTechnology(@Param("offset") Integer offset,@Param("rows") Integer rows);

    List<Technology> searchByPrimaryKey(@Param("searchValue") String searchValue,@Param("offset") Integer offset, @Param("rows")Integer rows);

    List<Technology> searchByName(@Param("searchValue") String searchValue,@Param("offset") Integer offset, @Param("rows")Integer rows);

    int deleteBatch( int [] ids);
}