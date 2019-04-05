package com.erp.web4j.controller;

import com.erp.web4j.bean.*;
import com.erp.web4j.service.TechnologyPlanService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/5 Time 13:14
 */
@Controller
@RequestMapping("technologyPlan")
public class TechnologyPlanController {

    @Autowired
    TechnologyPlanService technologyPlanService;

    @RequestMapping("find")
    public String find() {
        return "technologyPlan_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public QueryVo<TechnologyPlan> list(@RequestParam Integer page, @RequestParam Integer rows) {
        if (page == null || page <= 0) {
            page = 1;
        }
        if (rows <= 0) {
            rows = 10;
        }
        Integer records = technologyPlanService.countOrderRecords();
        List<TechnologyPlan> technologyPlans = technologyPlanService.listOrders(page, rows);
        QueryVo<TechnologyPlan> technologyPlanQueryVo = new QueryVo<>();
        technologyPlanQueryVo.setRows(technologyPlans);
        technologyPlanQueryVo.setTotal(records);
        return technologyPlanQueryVo;
    }

    @RequestMapping("add_judge")
    @ResponseBody
    public String addJudge() {
        return "";
    }

    @RequestMapping("add")
    public String add() {
        return "technologyPlan_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public StatusJson insert(TechnologyPlan technologyPlan) {
        //StatusJson statusJson = new StatusJson();
        if (technologyPlan != null) {
            boolean flag = technologyPlanService.insert(technologyPlan);
            if (flag) {
                return new StatusJson("200", "OK", null);
            } else {
                return new StatusJson("0", "该工艺编号已经存在，请更换工艺编号！", null);
            }
        } else {
            return new StatusJson("0", "输入有误，请重新输入", null);
        }
    }

    @RequestMapping("edit_judge")
    @ResponseBody
    public String editJudge() {
        return "";
    }

    @RequestMapping("edit")
    public String edit() {
        return "technologyPlan_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public StatusJson updateAll(TechnologyPlan technologyPlan) {

        boolean flag = technologyPlanService.update(technologyPlan);
        if (flag) {
            return new StatusJson("200", "OK", null);
        } else {
            return new StatusJson("0", "该工艺编号已经存在，请更换工艺编号！", null);
        }
    }




    @RequestMapping("delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "";
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public StatusJson deleteBatch(@RequestParam("ids")int[] ids){

            boolean flag = technologyPlanService.deleteBatch(ids);
            if(flag ){
                return new StatusJson("200","OK",null);
            }else {
                return new StatusJson("0","删除失败",null);
            }
        }

    /**
     * 通过id查询数据
     * @param searchValue  所输入的数据
     * @param page
     * @param rows
     * @return 查询到的数据
     */
    @RequestMapping("search_technologyPlan_by_technologyPlanId")
    @ResponseBody
    public QueryVo<TechnologyPlan> search_technology_by_technologyId(String  searchValue, Integer page, @Param("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        Integer records = technologyPlanService.countOrderRecords();
        List<TechnologyPlan> technologyPlans = technologyPlanService.searchByPrimaryKey(searchValue,page, rows);
        QueryVo<TechnologyPlan> technologyPlanQueryVo = new QueryVo<>();
        technologyPlanQueryVo.setRows(technologyPlans);
        technologyPlanQueryVo.setTotal(records);
        return technologyPlanQueryVo;
        /*return technologyPlanService.searchByPrimaryKey(searchValue,page, rows);*/
    }

    /**
     *  通过name查询数据
     * @param searchValue
     * @param page
     * @param rows
     * @return 返回查询到的数据
     */
    @RequestMapping("search_technologyPlan_by_technologyName")
    @ResponseBody
    public List<TechnologyPlan> searchTechnologyByTechnologyName(@RequestParam("searchValue")String  searchValue,@Param("page") Integer page,@Param("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        return  technologyPlanService.searchByName(searchValue, page, rows);
    }
}
