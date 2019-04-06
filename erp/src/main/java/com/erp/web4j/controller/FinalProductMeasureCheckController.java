package com.erp.web4j.controller;

import com.erp.web4j.bean.FinalMeasuretCheck;
import com.erp.web4j.bean.ProcessMeasureCheck;
import com.erp.web4j.bean.QueryVo;
import com.erp.web4j.bean.StatusJson;
import com.erp.web4j.service.FinalProductMeasureCheckService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by Yana
 * Date 2019/4/5 Time 0:32
 */
@Controller
public class FinalProductMeasureCheckController {

    @Autowired
    FinalProductMeasureCheckService finalProductMeasureCheckService;


    @RequestMapping("measure/find")
    public String findMeasureCheck(){
        return "measurement_list";
    }

    @RequestMapping("measure/list")
    @ResponseBody
    public QueryVo<ProcessMeasureCheck> listMeasureCheck(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows ){

        if(page == null || page < 0){
            page =1;
        }
        if(rows <= 0){
            rows = 10;
        }

        Integer records = finalProductMeasureCheckService.queryMeasureCheckRecords();

        ArrayList<ProcessMeasureCheck>  pMeasureCheckList = finalProductMeasureCheckService.queryMeasureCheck(page, rows);

        QueryVo<ProcessMeasureCheck>  processMeasureCheckQueryVo= new QueryVo<>();

        processMeasureCheckQueryVo.setRows( pMeasureCheckList);
        processMeasureCheckQueryVo.setTotal(records);

        return processMeasureCheckQueryVo;
    }

    @RequestMapping("fMeasureCheck/add_judge")
    @ResponseBody
    public String addJudge(){
        return "{}";
    }

    @RequestMapping("measure/add")
    public String add(){
        return "measurement_add";
    }

    @RequestMapping("measure/insert")
    @ResponseBody
    public StatusJson insert(FinalMeasuretCheck finalMeasuretCheck){

        StatusJson statusJson = new StatusJson();
        int insert = finalProductMeasureCheckService.insert(finalMeasuretCheck);
        if(insert == 1){
            statusJson.setStatus("200");
            statusJson.setMsg("ok");
        }else {
            statusJson.setStatus("000");
            statusJson.setMsg("fail");
        }
        return statusJson;
    }

    @RequestMapping("fMeasureCheck/edit_judge")
    @ResponseBody
    public String editJudge(){
        return "{}";
    }

    @RequestMapping("measure/edit")
    public String edit(){
        return "measurement_edit";
    }

    @RequestMapping("measure/update_all")
    public StatusJson update(FinalMeasuretCheck finalMeasuretCheck){

        int update = finalProductMeasureCheckService.update(finalMeasuretCheck);
        StatusJson statusJson = new StatusJson();
        if(update == 1){
            statusJson.setMsg("ok");
            statusJson.setStatus("200");
        }else {
            statusJson.setMsg("fail");
            statusJson.setStatus("000");
        }
        return statusJson;
    }

    @RequestMapping("fMeasureCheck/delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "{}";
    }

    @RequestMapping("measure/delete_batch")
    @ResponseBody
    public StatusJson deleteBatch(@Param("ids") String[] ids){
        StatusJson statusJson = new StatusJson();
        int deleteCount = finalProductMeasureCheckService.delete(ids);
        if(ids == null || ids.length ==0){
            statusJson.setStatus("000");
            statusJson.setMsg("not check");
        }else if(deleteCount>0 && deleteCount< ids.length){
            statusJson.setMsg("fail");
            statusJson.setStatus("000");
        }else if(deleteCount == ids.length){
            statusJson.setStatus("200");
            statusJson.setMsg("ok");
        }else {
            statusJson.setMsg("fail");
            statusJson.setStatus("000");
        }
        return statusJson;
    }
    @RequestMapping("measure/search_fMeasureCheck_by_fMeasureCheckId")
    @ResponseBody
    public QueryVo<FinalMeasuretCheck> searchById(String searchValue, @RequestParam("page") Integer page, @RequestParam("rows") Integer rows){

        if(page == null || page<0) {
            page = 1;
        }
        if(rows <= 0){
            rows=10;
        }

        QueryVo<FinalMeasuretCheck> finalMeasuretCheckQueryVo = new QueryVo<>();
        ArrayList<FinalMeasuretCheck> finalMeasureCheckList = finalProductMeasureCheckService.finalMeasureCheckListById(searchValue, page, rows);
        int count = finalProductMeasureCheckService.queryCountById(searchValue, page, rows);
        finalMeasuretCheckQueryVo.setRows(finalMeasureCheckList);
        finalMeasuretCheckQueryVo.setTotal(count);
        return finalMeasuretCheckQueryVo;

    }

    @RequestMapping("measure/search_fMeasureCheck_by_orderId")
    @ResponseBody
    public QueryVo<FinalMeasuretCheck> searchFMeasureCheckByOrderId(String searchValue, @Param("page") Integer page, @Param("rows") Integer rows){

        if(page == null || page<0){
            page = 1;
        }
        if(rows <= 0){
            rows =10;
        }

        QueryVo<FinalMeasuretCheck> finalMeasuretCheckQueryVo = new QueryVo<>();
        ArrayList<FinalMeasuretCheck> finalMeasureCheckList = finalProductMeasureCheckService.finalMeasureCheckListByOrderId(searchValue, page, rows);
        int query = finalProductMeasureCheckService.queryMeasureCheckRecordsByOrderId(searchValue);
        finalMeasuretCheckQueryVo.setTotal(query);
        finalMeasuretCheckQueryVo.setRows(finalMeasureCheckList);
        return finalMeasuretCheckQueryVo;

    }






}
