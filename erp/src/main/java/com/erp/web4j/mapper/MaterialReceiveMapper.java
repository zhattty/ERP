package com.erp.web4j.mapper;

import com.erp.web4j.bean.MaterialReceive;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialReceiveMapper {
    int deleteByPrimaryKey(String receiveId);

    int insert(MaterialReceive record);

    int insertSelective(MaterialReceive record);

    MaterialReceive selectByPrimaryKey(String receiveId);

    int updateByPrimaryKeySelective(MaterialReceive record);

    int updateByPrimaryKey(MaterialReceive record);

    List<MaterialReceive> selectAll();

    int deleteByPrimaryKeyBanch(@Param("ids") String[] ids);

    List<MaterialReceive> selectLikePrimaryKey(String receiveId);

    List<MaterialReceive> selectLikeMaterialId(String materialId);
}