package com.erp.web4j.mapper;

import com.erp.web4j.bean.Material;

public interface MaterialMapper {
    int deleteByPrimaryKey(String materialId);

    int insert(Material record);

    int insertSelective(Material record);

    Material selectByPrimaryKey(String materialId);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);
}