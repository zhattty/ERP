package com.erp.web4j.mapper;

import com.erp.web4j.bean.UnqualifyApply;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface UnqualifyApplyMapper {
    int deleteByPrimaryKey(String unqualifyApplyId);

    int insert(UnqualifyApply record);

    int insertSelective(UnqualifyApply record);

    UnqualifyApply selectByPrimaryKey(String unqualifyApplyId);

    int updateByPrimaryKeySelective(UnqualifyApply record);

    int updateByPrimaryKey(UnqualifyApply record);


    Integer countUnqualifyRecords();

    ArrayList<UnqualifyApply> queryUnqualifyApply(@Param("offset") Integer offset,@Param("rows") Integer rows);
}