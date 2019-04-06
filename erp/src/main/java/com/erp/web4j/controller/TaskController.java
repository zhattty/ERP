package com.erp.web4j.controller;

import com.erp.web4j.bean.QueryVo;
import com.erp.web4j.bean.StatusJson;
import com.erp.web4j.bean.Task;
import com.erp.web4j.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/5 Time 21:49
 */
@Controller
@RequestMapping("task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @RequestMapping("find")
    public String findTask(){
        return "task_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public QueryVo<Task>  listPageTask(@RequestParam("page")Integer page,
                                       @RequestParam("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Task> tasks = taskService.listPageTask(page, rows);
        int records = taskService.countAllTaskRecords();
        QueryVo<Task> manufactureQueryVo = new QueryVo<>();
        manufactureQueryVo.setTotal(records);
        manufactureQueryVo.setRows(tasks);
        return manufactureQueryVo;
    }

    @RequestMapping("add")
    public String showAddTask(){
        return "task_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public StatusJson insertTask(Task task){
        StatusJson statusJson = new StatusJson();
        if (task == null){
            statusJson.setMsg("请输入参数");
            return statusJson;
        }
        if (task.getTaskId() == null || task.getWorkId() == null || task.getManufactureSn() == null){
            statusJson.setMsg("必填项不能为空");
            return statusJson;
        }
        boolean isExist = taskService.checkTaskId(task.getTaskId());
        if (isExist){
            statusJson.setMsg("派工编号重复");
            return statusJson;
        }
        int result = taskService.insertTask(task);
        if (result == 1){
            statusJson.setStatus("200");
        }else {
            statusJson.setMsg("插入失败");
        }
        return statusJson;
    }

    @RequestMapping("edit")
    public String showEditTask(){
        return "task_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public StatusJson updateTask(Task task){
        StatusJson statusJson = new StatusJson();
        if (task == null){
            statusJson.setMsg("请输入参数");
            return statusJson;
        }
        if (task.getTaskId() == null || task.getWorkId() == null || task.getManufactureSn() == null){
            statusJson.setMsg("必填项不能为空");
            return statusJson;
        }

        int result = taskService.updateTaskById(task);
        if (result == 1){
            statusJson.setStatus("200");
        }else {
            statusJson.setMsg("修改失败");
        }
        return statusJson;
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public StatusJson deleteTaskByIds(@RequestParam("ids")String[] ids){
        StatusJson statusJson = new StatusJson();
        if (ids == null || ids.length == 0){
            statusJson.setMsg("请勾选需要删除的对象");
            return statusJson;
        }
        int count = taskService.deleteByIds(ids);
        if (count != ids.length){
            statusJson.setMsg("删除失败");
        }else {
            statusJson.setStatus("200");
        }
        return statusJson;
    }

    @RequestMapping("search_task_by_taskId")
    @ResponseBody
    public QueryVo<Task> searchTaskByTaskId(String searchValue,
                                            @RequestParam("page")Integer page,
                                            @RequestParam("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Task> tasks = taskService.searchTaskByTaskId(searchValue, page, rows);
        int records = taskService.countTaskByTaskId(searchValue);
        QueryVo<Task> manufactureQueryVo = new QueryVo<>();
        manufactureQueryVo.setTotal(records);
        manufactureQueryVo.setRows(tasks);
        return manufactureQueryVo;
    }

    @RequestMapping("search_task_by_taskWorkId")
    @ResponseBody
    public QueryVo<Task> searchTaskByWorkId(String searchValue,
                                            @RequestParam("page")Integer page,
                                            @RequestParam("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Task> tasks = taskService.searchTaskByWorkId(searchValue, page, rows);
        int records = taskService.countTaskByWorkId(searchValue);
        QueryVo<Task> manufactureQueryVo = new QueryVo<>();
        manufactureQueryVo.setTotal(records);
        manufactureQueryVo.setRows(tasks);
        return manufactureQueryVo;
    }

    @RequestMapping("search_task_by_taskManufactureSn")
    @ResponseBody
    public QueryVo<Task> searchTaskByManufactureSn(String searchValue,
                                            @RequestParam("page")Integer page,
                                            @RequestParam("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Task> tasks = taskService.searchTaskBySn(searchValue, page, rows);
        int records = taskService.countTaskBySn(searchValue);
        QueryVo<Task> manufactureQueryVo = new QueryVo<>();
        manufactureQueryVo.setTotal(records);
        manufactureQueryVo.setRows(tasks);
        return manufactureQueryVo;
    }


}
