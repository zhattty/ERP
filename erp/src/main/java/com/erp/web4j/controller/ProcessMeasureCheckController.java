package com.erp.web4j.controller;


import com.erp.web4j.bean.ProcessMeasureCheck;
import com.erp.web4j.bean.QueryVo;
import com.erp.web4j.bean.StatusJson;
import com.erp.web4j.service.ProcessMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by Yana
 * Date 2019/4/7 Time 17:30
 */
@Controller
public class ProcessMeasureCheckController {
    @Autowired
    ProcessMeasureCheckService processMeasureCheckService;


    @RequestMapping("p_measure_check/find")
    public String find() {
        return "p_measure_check_list";
    }

    @RequestMapping("p_measure_check/list")
    @ResponseBody
    public QueryVo<ProcessMeasureCheck> proccessMeasureCheckList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){

        if(page == null || page < 0){
            page = 1;
        }
        if(rows <= 0) {
            rows = 10;
        }
        ArrayList<ProcessMeasureCheck> processMeasureCheckList = processMeasureCheckService.queryAllList(page,rows);
        int count = processMeasureCheckService.queryCount();
        QueryVo<ProcessMeasureCheck> processMeasureCheckQueryVo = new QueryVo<>();
        processMeasureCheckQueryVo.setRows(processMeasureCheckList);
        processMeasureCheckQueryVo.setTotal(count);
        return processMeasureCheckQueryVo;

    }

    @RequestMapping("pMeasureCheck/add_judge")
    @ResponseBody
    public String addJudge(){
        return "{}";
    }


    @RequestMapping("p_measure_check/add")
    public String add(){
        return "p_measure_check_add";
    }

    @RequestMapping("p_measure_check/insert")
    @ResponseBody
    public StatusJson insert(ProcessMeasureCheck processMeasureCheck){
        StatusJson statusJson = new StatusJson();
        int insert = processMeasureCheckService.insert(processMeasureCheck);
        if(insert == 1){
            statusJson.setMsg("ok");
            statusJson.setStatus("200");
        }else {
            statusJson.setStatus("000");
            statusJson.setMsg("fail");
        }
        return statusJson;
    }

    @RequestMapping("pMeasureCheck/edit_judge")
    @ResponseBody()
    public String editJudge(){

        return "{}";
    }

    @RequestMapping("p_measure_check/edit")
    public String edit(){
        return "p_measure_check_edit";
    }

    @RequestMapping("p_measure_check/update_all")
    @ResponseBody
    public StatusJson update(ProcessMeasureCheck processMeasureCheck){
        StatusJson statusJson = new StatusJson();
        int update = processMeasureCheckService.update(processMeasureCheck);
        if(update == 1) {
            statusJson.setMsg("0k");
            statusJson.setStatus("200");
        }else {
            statusJson.setMsg("fail");
            statusJson.setStatus("000");
        }
        return statusJson;
    }

    @RequestMapping("pMeasureCheck/delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "{}";
    }

    @RequestMapping("p_measure_check/delete_batch")
    @ResponseBody
    public StatusJson deleteBatch(String[] ids){
        StatusJson statusJson = new StatusJson();
        int deleteCount = processMeasureCheckService.deleteByIds(ids);
        if(ids == null || ids.length == 0 ){
            statusJson.setMsg("not check");
            statusJson.setStatus("000");
        } else if(deleteCount > 0 && deleteCount < ids.length ){
            statusJson.setMsg("only delete part");
            statusJson.setMsg("000");
        }else if(deleteCount == ids.length){
            statusJson.setStatus("200");
            statusJson.setMsg("ok");
        }else {
            statusJson.setMsg("fail");
            statusJson.setStatus("000");
        }
        return statusJson;
    }

    @RequestMapping("p_measure_check/search_pMeasureCheck_by_pMeasureCheckId")
    @ResponseBody
    public QueryVo<ProcessMeasureCheck> searchFCountCheckByFCountCheckId(String searchValue, @RequestParam("page") Integer page, @RequestParam("rows")Integer rows ){
        if(page == null || page < 0){
            page=1;
        }
        if(rows <= 0){
            rows = 10;
        }

        ArrayList<ProcessMeasureCheck> processMeasureCheckArrayList = processMeasureCheckService.queryListByCheckId(searchValue, page, rows);
        int count = processMeasureCheckService.queryNumberByCheckId(searchValue);
        QueryVo<ProcessMeasureCheck>  processMeasureCheckQueryVo = new QueryVo<>();
        processMeasureCheckQueryVo.setTotal(count);
        processMeasureCheckQueryVo.setRows( processMeasureCheckArrayList);
        return  processMeasureCheckQueryVo;

    }


}
