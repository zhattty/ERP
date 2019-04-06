package com.erp.web4j.controller;

import com.erp.web4j.bean.QueryVo;
import com.erp.web4j.bean.StatusJson;
import com.erp.web4j.bean.Work;
import com.erp.web4j.service.WorkService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/5 Time 10:09
 */
@Controller
@RequestMapping("work")
public class WorkController {
    @Autowired
    WorkService workService;

    @RequestMapping("find")
    public String findWorkList(){
        return "work_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public QueryVo<Work> listPageWork(@RequestParam("page")Integer page, @RequestParam("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Work> works = workService.listPageWork(page, rows);
        int records = workService.countAllRecords();
        QueryVo<Work> workQueryVo = new QueryVo<>();
        workQueryVo.setRows(works);
        workQueryVo.setTotal(records);
//        System.out.println(workQueryVo);
        return workQueryVo;
    }

    @RequestMapping("add")
    public String showAdd(){
        return "work_add";
    }
    // 此处没有其他人的getData暂时无法完成insert

    @RequestMapping("edit")
    public String edit(){
        return "work_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public StatusJson updateWorkById(Work work){
        StatusJson statusJson = new StatusJson();
        //校验
        int result = workService.updateWorkById(work);
        if (result == 1){
            statusJson.setStatus("200");
        }else {
            statusJson.setMsg("更新失败");
        }
        return statusJson;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    @RequestMapping("delete_batch")
    @ResponseBody
    public StatusJson deleteWorkByIds(@RequestParam("ids")String[] ids){
        StatusJson statusJson = new StatusJson();
        if (ids == null || ids.length == 0){
            statusJson.setMsg("请勾选需要删除的对象");
            return statusJson;
        }
        int count = workService.deleteWorkByIds(ids);
        if (count == ids.length){
            statusJson.setStatus("200");
        }else {
            statusJson.setMsg("删除失败");
        }
        return statusJson;
    }

    @RequestMapping("search_work_by_workId")
    @ResponseBody
    public QueryVo<Work> searchWorkById(String searchValue,
                                        @RequestParam(value = "page")Integer page,
                                        @RequestParam("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Work> works = workService.searchWorkById(searchValue, page, rows);
        int records = workService.countWorkRecordsById(searchValue);
        QueryVo<Work> workQueryVo = new QueryVo<>();
        workQueryVo.setRows(works);
        workQueryVo.setTotal(records);
        System.out.println(workQueryVo);
        return workQueryVo;
    }

    @RequestMapping("search_work_by_workProcess")
    @ResponseBody
    public QueryVo<Work> searchWorkByProcessId(String searchValue,
                                        @RequestParam(value = "page")Integer page,
                                        @RequestParam("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Work> works = workService.searchWorkByProcessId(searchValue, page, rows);
        int records = workService.countWorkRecordsByProcessId(searchValue);
        QueryVo<Work> workQueryVo = new QueryVo<>();
        workQueryVo.setRows(works);
        workQueryVo.setTotal(records);
        System.out.println(workQueryVo);
        return workQueryVo;
    }

    @RequestMapping("search_work_by_workProduct")
    @ResponseBody
    public QueryVo<Work> searchWorkByProductName(String searchValue,
                                               @RequestParam(value = "page")Integer page,
                                               @RequestParam("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Work> works = workService.searchWorkByProductName(searchValue, page, rows);
        int records = workService.countWorkRecordsByProductName(searchValue);
        QueryVo<Work> workQueryVo = new QueryVo<>();
        workQueryVo.setRows(works);
        workQueryVo.setTotal(records);
        System.out.println(workQueryVo);
        return workQueryVo;
    }


    @RequestMapping("search_work_by_workDevice")
    @ResponseBody
    public QueryVo<Work> searchWorkBy(String searchValue,
                                      @RequestParam(value = "page")Integer page,
                                      @RequestParam("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Work> works = workService.searchWorkByDeviceName(searchValue, page, rows);
        int records = workService.countWorkRecordsByDeviceName(searchValue);
        QueryVo<Work> workQueryVo = new QueryVo<>();
        workQueryVo.setRows(works);
        workQueryVo.setTotal(records);
        System.out.println(workQueryVo);
        return workQueryVo;
    }

    @RequestMapping("get/{workId}")
    @ResponseBody
    public Work getWorkById(@PathVariable String workId){
        return workService.selectWorkById(workId);
    }

    @RequestMapping("get_data")
    @ResponseBody
    public List<Work> getWorkData(){
        return workService.listWork();
    }

}
