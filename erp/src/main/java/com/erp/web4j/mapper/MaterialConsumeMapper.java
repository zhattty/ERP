package com.erp.web4j.mapper;

import com.erp.web4j.bean.MaterialConsume;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialConsumeMapper {
    int deleteByPrimaryKey(String consumeId);

    int insert(MaterialConsume record);

    int insertSelective(MaterialConsume record);

    MaterialConsume selectByPrimaryKey(String consumeId);

    int updateByPrimaryKeySelective(MaterialConsume record);

    int updateByPrimaryKey(MaterialConsume record);

    List<MaterialConsume> selectAll();

    List<MaterialConsume> selectBymaterialId(@Param("materialId") String materialId, Integer pageNum, Integer pageSize);

    List<MaterialConsume> selectByConsumeId(@Param("consumeId") String consumeId, Integer pageNum, Integer pageSize);

    List<MaterialConsume> selectByWorkId(@Param("workId") String workId, Integer pageNum, Integer pageSize);

    int deleteByPrimaryKeyBantch(@Param("ids") String[] ids);
}