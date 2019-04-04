package com.erp.web4j.mapper;

import com.erp.web4j.bean.Material;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialMapper {
    int deleteByPrimaryKey(String materialId);

    int deleteByPrimaryKeyBanch(@Param("ids") String[] ids);

    int insert(Material record);

    int insertSelective(Material record);

    Material selectByPrimaryKey(String materialId);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);

    List<Material> selectAll();

    List<Material> selectLikeID(@Param("materialId") String searchValue);

    List<Material> selectByType(@Param("materialType") String searchValue);

    List<String> selectIds();
}