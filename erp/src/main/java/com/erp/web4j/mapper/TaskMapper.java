package com.erp.web4j.mapper;

import com.erp.web4j.bean.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMapper {
    int deleteByPrimaryKey(String taskId);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(String taskId);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    List<Task> listPageTask(@Param("offset") Integer offset,
                            @Param("limit") Integer limit);

    int countAllTaskRecords();

    int countTaskById(String taskId);

    int deleteTaskByIds(@Param("ids") String[] ids);

    List<Task> listPageTaskByTaskId(@Param("taskId") String taskId,
                                    @Param("offset") Integer offset,
                                    @Param("limit") Integer limit);

    int countTaskRecordsByTaskId(String s);

    List<Task> listPageTaskByWorkId(@Param("workId") String workId,
                                    @Param("offset") Integer offset,
                                    @Param("limit") Integer limit);

    int countTaskRecordsByWorkId(String s);

    List<Task> listPageTaskBySn(@Param("sn") String sn,
                                @Param("offset") Integer offset,
                                @Param("limit") Integer limit);

    int countTaskRecordsBySn(String s);
}