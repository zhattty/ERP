package com.erp.web4j.controller;

import com.erp.web4j.bean.Custom;
import com.erp.web4j.bean.QueryVo;
import com.erp.web4j.bean.StatusJson;
import com.erp.web4j.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/4 Time 13:53
 */
@Controller
@RequestMapping("custom")
public class CustomController {

    @Autowired
    CustomService customService;

    @RequestMapping("get_data")
    @ResponseBody
    public List<Custom> getCustomData(){
        return customService.listAllCustoms();
    }

    @RequestMapping("find")
    public String findCustom(){
        return "custom_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public QueryVo<Custom> listAllCustom(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Custom> customs = customService.listAllCustomsWithPageAndRows(page, rows);
        int records = customService.countAllCustomRecords();
        QueryVo<Custom> customOrderQueryVo = new QueryVo<>();
        customOrderQueryVo.setRows(customs);
        customOrderQueryVo.setTotal(records);
        System.out.println(customOrderQueryVo);
        return customOrderQueryVo;
    }

    @RequestMapping("add")
    public String addCustom(){
        return "custom_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public StatusJson insertCustom(Custom custom){
        StatusJson statusJson = new StatusJson();
        if (custom.getCustomId() == null || custom.getCustomName() == null){
            statusJson.setMsg("客户id和客户名不能为空");
            return statusJson;
        }
       boolean isIdExsit = customService.checkCustomId(custom.getCustomId());
        if (isIdExsit){
            statusJson.setMsg("id重复");
            return  statusJson;
        }
        int result = customService.addCustom(custom);
        if (result == 1){
            statusJson.setStatus("200");
        }else {
            statusJson.setMsg("插入失败");
        }
        return statusJson;
    }

    @RequestMapping("edit")
    public String editCustom(){
        return "custom_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public StatusJson updateCustomById(Custom custom){
        StatusJson statusJson = new StatusJson();
        if (custom.getCustomId() == null || custom.getCustomName() == null){
            statusJson.setMsg("客户id和客户名不能为空");
            return statusJson;
        }
        int result = customService.updateCustomById(custom);
        if (result == 1){
            statusJson.setStatus("200");
        }else {
            statusJson.setMsg("插入失败");
        }
        return statusJson;
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public StatusJson deleteCustomByIds(@RequestParam("ids") String[] ids){
        StatusJson statusJson = new StatusJson();
        if (ids == null || ids.length == 0){
            statusJson.setMsg("请勾选需要删除的对象");
            return statusJson;
        }
        int count = customService.deleteCustomByIds(ids);
        if (count == ids.length){
            statusJson.setStatus("200");
        }else if (count > 0 && count < ids.length){
            statusJson.setMsg("未完全删除");
        }else {
            statusJson.setMsg("删除失败");
        }
        return statusJson;
    }

    @RequestMapping("search_custom_by_customId")
    @ResponseBody
    public QueryVo<Custom> searchCustomByCustomId(String searchValue,
                                                  @RequestParam("page") Integer page,
                                                  @RequestParam("rows") Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Custom> customs = customService.listCustomsByCustomId(searchValue,page, rows);
        int records = customService.countCustomRecordsByCustomId(searchValue);
        QueryVo<Custom> customOrderQueryVo = new QueryVo<>();
        customOrderQueryVo.setRows(customs);
        customOrderQueryVo.setTotal(records);
        System.out.println(customOrderQueryVo);
        return customOrderQueryVo;
    }

    @RequestMapping("search_custom_by_customName")
    @ResponseBody
    public QueryVo<Custom> searchCustomByCustomName(String searchValue,
                                                  @RequestParam("page") Integer page,
                                                  @RequestParam("rows") Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Custom> customs = customService.listCustomsByCustomName(searchValue,page, rows);
        int records = customService.countCustomRecordsByCustomName(searchValue);
        QueryVo<Custom> customOrderQueryVo = new QueryVo<>();
        customOrderQueryVo.setRows(customs);
        customOrderQueryVo.setTotal(records);
        System.out.println(customOrderQueryVo);
        return customOrderQueryVo;
    }

    @RequestMapping("get/{customId}")
    @ResponseBody
    public Custom getCustomById(@PathVariable String customId){
        Custom custom1 = customService.selectCustomByCustomId(customId);
        return custom1;
    }

}
