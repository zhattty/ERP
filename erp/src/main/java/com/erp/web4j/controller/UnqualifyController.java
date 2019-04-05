package com.erp.web4j.controller;

import com.erp.web4j.bean.QueryVo;
import com.erp.web4j.bean.StatusJson;
import com.erp.web4j.bean.UnqualifyApply;
import com.erp.web4j.service.UnqualifyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Yana
 * Date 2019/4/4 Time 11:17
 */

@Controller
public class UnqualifyController {
    @Autowired
    UnqualifyService unqualityService;

    @RequestMapping("unqualify/find")
    public String findUnqualifyApply(){
        return "unqualify_list";
    }

    @RequestMapping("unqualify/list")
    @ResponseBody()
    public QueryVo<UnqualifyApply> listUnqualify(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){

        if(page == null || page < 0 ){
            page = 1;
        }
        if(rows <= 0){
            rows=10;
        }
        Integer records =unqualityService.countUnqualifyRecords();
        ArrayList<UnqualifyApply> unqualifyApplies = unqualityService.queryUnqualifyApply(page, rows);
        QueryVo<UnqualifyApply> unqualifyQueryVo = new QueryVo<>();
        unqualifyQueryVo.setRows(unqualifyApplies);
        unqualifyQueryVo.setTotal(records );

        return unqualifyQueryVo;
    }

    @RequestMapping("unqualify/add_judge")
    @ResponseBody
    public String add_judge(){
        return "{}";
    }

    @RequestMapping("unqualify/add")
    public String add(){
        return "unqualify_add";
    }

    @RequestMapping("unqualify/insert")
    @ResponseBody
    public StatusJson insert(UnqualifyApply unqualifyApply){

        StatusJson statusJson = new StatusJson();
        int insert = unqualityService.insertUnqualifyApply(unqualifyApply);
        if(insert == 1){
            statusJson.setMsg("ok");
            statusJson.setStatus("200");
        }else {
            statusJson.setStatus("000");
            statusJson.setMsg("fail");
        }
        return statusJson;
    }

    @RequestMapping("unqualify/edit_judge")
    @ResponseBody
    public String edit_judge(){
        return "{}";
    }

    @RequestMapping("unqualify/edit")
    public String editUnqualify(){
        return "unqualify_edit";
    }

    @RequestMapping("unqualify/update_all")
    @ResponseBody
    public StatusJson update(UnqualifyApply unqualifyApply){
        StatusJson statusJson = new StatusJson();
        int update = unqualityService.updateUnqualifyApply(unqualifyApply);
        if(update == 1) {
            statusJson.setMsg("0k");
            statusJson.setStatus("200");
        }else {
            statusJson.setMsg("fail");
            statusJson.setStatus("000");
        }
        return statusJson;
    }

    @RequestMapping("unqualify/delete_judge")
    @ResponseBody
    public String delete_judge(){
        return "{}";
    }

    @RequestMapping("unqualify/delete_batch")
    @ResponseBody
    public StatusJson deleteUnqualifyApply(@Param("ids") int[] ids){

        StatusJson statusJson = new StatusJson();
        int delete = unqualityService.deleteUnqualifyApply(ids);
        if(ids == null || ids.length ==0){
            statusJson.setStatus("000");
            statusJson.setMsg("没有选择要删除的对象");
        }else if(delete>0 && delete < ids.length){
            statusJson.setMsg("删除出问题啦");
            statusJson.setStatus("000");
        }else if(delete == ids.length){
            statusJson.setStatus("200");
            statusJson.setMsg("ok");
        }else {
            statusJson.setMsg("fail");
            statusJson.setStatus("000");
        }
        return statusJson;
    }

    @RequestMapping("unqualify/search_unqualify_by_unqualifyId")
    @ResponseBody
    public QueryVo<UnqualifyApply> searchUnqualifyByUnqualifyId( String searchValue,
                                                                 @RequestParam("page") Integer page,
                                                                 @RequestParam("rows")Integer rows){

        if(page == null || page < 0 ){
            page = 1;
        }
        if(rows <= 0){
            rows=10;
        }
        QueryVo<UnqualifyApply> unqualifyApplyQueryVo = new QueryVo<>();
        ArrayList<UnqualifyApply> unqualifyApplies = unqualityService.listUnqualifyApply(searchValue, page, rows);
        int count =  unqualityService.countUnqualifyRecordsById(searchValue);
        unqualifyApplyQueryVo.setTotal(count);
        unqualifyApplyQueryVo.setRows(unqualifyApplies);

        return unqualifyApplyQueryVo;
    }

    @RequestMapping("unqualify/search_unqualify_by_productName")
    @ResponseBody
    public QueryVo<UnqualifyApply> searchUnqualifyByUnqualifyProductName( String searchValue,
                                                                          @RequestParam("page") Integer page,
                                                                          @RequestParam("rows")Integer rows){
        if(page == null || page <0){
            page = 1;
        }
        if(rows <= 0){
            rows = 10;
        }
        QueryVo<UnqualifyApply> unqualifyApplyQueryVo = new QueryVo<>();
        ArrayList<UnqualifyApply> unqualifyApplies = unqualityService.listUnqualifyApplyByProductName(searchValue, page, rows);
        int count =  unqualityService.countUnqualifyRecordsByProductName(searchValue);
        unqualifyApplyQueryVo.setTotal(count);
        unqualifyApplyQueryVo.setRows(unqualifyApplies);

        return unqualifyApplyQueryVo;


    }







}
