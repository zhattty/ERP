package com.erp.web4j.service.impl;

import com.erp.web4j.bean.Task;
import com.erp.web4j.mapper.TaskMapper;
import com.erp.web4j.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/5 Time 21:51
 */

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;

    @Override
    public List<Task> listPageTask(Integer page, Integer rows) {
        return taskMapper.listPageTask((page - 1) * rows, rows);
    }

    @Override
    public int countAllTaskRecords() {
        return taskMapper.countAllTaskRecords();
    }

    @Override
    public boolean checkTaskId(String taskId) {
        return taskMapper.countTaskById(taskId) > 0;
    }

    @Override
    public int insertTask(Task task) {
        return taskMapper.insert(task);
    }

    @Override
    public int updateTaskById(Task task) {
        return taskMapper.updateByPrimaryKey(task);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return taskMapper.deleteTaskByIds(ids);
    }

    @Override
    public List<Task> searchTaskByTaskId(String searchValue, Integer page, Integer rows) {
        return taskMapper.listPageTaskByTaskId("%" + searchValue + "%", (page - 1) * rows, rows);
    }

    @Override
    public int countTaskByTaskId(String searchValue) {
        return taskMapper.countTaskRecordsByTaskId("%" + searchValue + "%");
    }

    @Override
    public List<Task> searchTaskByWorkId(String searchValue, Integer page, Integer rows) {
        return taskMapper.listPageTaskByWorkId("%" + searchValue + "%", (page - 1) * rows, rows);
    }

    @Override
    public int countTaskByWorkId(String searchValue) {
        return taskMapper.countTaskRecordsByWorkId("%" + searchValue + "%");
    }

    @Override
    public List<Task> searchTaskBySn(String searchValue, Integer page, Integer rows) {
        return taskMapper.listPageTaskBySn("%" + searchValue + "%", (page - 1) * rows, rows);
    }

    @Override
    public int countTaskBySn(String searchValue) {
        return taskMapper.countTaskRecordsBySn("%" + searchValue + "%");
    }
}
