package com.erp.web4j.mapper;

import com.erp.web4j.bean.Work;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkMapper {
    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(String workId);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    List<Work> listPageWork(@Param("offset") Integer offset,@Param("limit") Integer limit);

    int countAllRecords();

    int deleteWorkByIds(@Param("ids") String[] ids);

    List<Work> listPageWorkById(@Param("workId") String workId,
                                @Param("offset") Integer offset,
                                @Param("limit") Integer limit);

    int countWorkRecordsById(String s);

    List<Work> listPageWorkByProcessId(@Param("processId") String processId,
                                       @Param("offset") Integer offset,
                                       @Param("limit") Integer limit);

    int countWorkRecordsByProcessId(String s);

    List<Work> listPageWorkByProductName(@Param("productName") String productName,
                                         @Param("offset") Integer offset,
                                         @Param("limit") Integer limit);

    int countWorkRecordsByProductName(String s);

    List<Work> listPageWorkByDeviceName(@Param("deviceName") String deviceName,
                                        @Param("offset") Integer offset,
                                        @Param("limit") Integer limit);

    int countWorkRecordsByDeviceName(String s);

    List<Work> listWork();

    int countWorkRecordsByIdExplicit(String workId);
}