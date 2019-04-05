package com.erp.web4j.mapper;

import com.erp.web4j.bean.Process;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessMapper {
    int deleteByPrimaryKey(String processId);

    int insert(Process record);

    int insertSelective(Process record);

    Process selectByPrimaryKey(String processId);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);

    Integer countOrderRecords();

    List<Process> searchByPrimaryKey(Integer page, Integer rows);

    Integer deleteBatch(int[] ids);

    List<Process> searchByPrimaryKey2(@Param("searchValue") String searchValue, Integer page, Integer rows);

    List<Process> searchByTechnologyId(@Param("searchValue") String searchValue, Integer page, Integer rows);
}