package com.erp.web4j.service;

import com.erp.web4j.bean.Task;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/5 Time 21:50
 */
public interface TaskService {
    List<Task> listPageTask(Integer page, Integer rows);

    int countAllTaskRecords();

    boolean checkTaskId(String taskId);

    int insertTask(Task task);

    int updateTaskById(Task task);

    int deleteByIds(String[] ids);

    List<Task> searchTaskByTaskId(String searchValue, Integer page, Integer rows);

    int countTaskByTaskId(String searchValue);

    List<Task> searchTaskByWorkId(String searchValue, Integer page, Integer rows);

    int countTaskByWorkId(String searchValue);

    List<Task> searchTaskBySn(String searchValue, Integer page, Integer rows);

    int countTaskBySn(String searchValue);
}
