package com.erp.web4j.mapper;

import com.erp.web4j.bean.Custom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomMapper {
    int deleteByPrimaryKey(String customId);

    int insert(Custom record);

    int insertSelective(Custom record);

    Custom selectByPrimaryKey(String customId);

    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);

    List<Custom> listAllCustoms();

    Integer countAllCustomRecords();

    List<Custom> listAllCustomsWithOffsetAndLimit(@Param("offset") Integer offset, @Param("limit") Integer limit);

    Integer countCustomById(String customId);

    int deleteByIds(@Param("ids") String[] ids);

    List<Custom> listCustomsByCustomId(@Param("customId") String customId,
                                       @Param("offset") Integer offset,
                                       @Param("limit") Integer limit);

    Integer countCustomRecordsByCustomId(String searchValue);


    List<Custom> listCustomsByCustomName(@Param("customName") String customName,
                                         @Param("offset") Integer offset,
                                         @Param("limit") Integer limit);

    Integer countCustomRecordsByCustomName(String s);
}
