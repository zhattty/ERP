package com.erp.web4j.controller;

import com.erp.web4j.bean.*;
import com.erp.web4j.service.TechnologyRequirementService;
import com.erp.web4j.service.TechnologyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/4 Time 10:10
 */
@Controller
@RequestMapping("technologyRequirement")
public class TechnologyRequirementController {


    /**
     * 注入Service
     */
    @Autowired
    TechnologyRequirementService requirementService;


    @RequestMapping("find")
    public String find(){
        return "technologyRequirement_list";
    }


    /**
     * 异步查询请求
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public QueryVo<TechnologyRequirement> list(@RequestParam("page") Integer page, @RequestParam("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        /*List<Technology> technologyList = requirementService.findTechnology(page, rows);*/
        Integer records = requirementService.countOrderRecords();
        List<TechnologyRequirement> technologyRequirements = requirementService.listOrders(page, rows);
        QueryVo<TechnologyRequirement> technologyRequirementQueryVo = new QueryVo<>();
        technologyRequirementQueryVo.setRows(technologyRequirements);
        technologyRequirementQueryVo.setTotal(records);
        //System.out.println(technologyRequirementQueryVo);
        return technologyRequirementQueryVo;

    }

    @RequestMapping("add_judge")
    @ResponseBody
    public String add_judge(){
        return "";
    }

    @RequestMapping("add")
    public String add(){
        return "technologyRequirement_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public StatusJson insert( TechnologyRequirement technologyRequirement){
        //StatusJson statusJson = new StatusJson();
        if(technologyRequirement!=null) {
            boolean flag = requirementService.insert(technologyRequirement);
            if(flag ){
                return new StatusJson("200","OK",null);
            }else {
                return new StatusJson("0","该工艺编号已经存在，请更换工艺编号！",null);
            }
        }else {
            return new StatusJson("0","输入有误，请重新输入",null);
        }
    }


    @Autowired
    TechnologyService technologyService;

    @RequestMapping("get_data")
    @ResponseBody
    public List<Technology> getData(){
        List<Technology> technologies = technologyService.findTechnology(1, 30);
        return technologies;
    }

    @RequestMapping("edit_judge")
    @ResponseBody
    public String edit_judge(){
        return "";
    }

    @RequestMapping("edit")
    public String edit(){
        return "technologyRequirement_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public StatusJson update_all(TechnologyRequirement technologyRequirement){
        if(technologyRequirement!=null) {
            boolean flag = requirementService.update(technologyRequirement);
            if(flag ){
                return new StatusJson("200","OK",null);
            }else {
                return new StatusJson("0","该工艺编号已经存在，请更换工艺编号！",null);
            }
        }else {
            return new StatusJson("0","输入有误，请重新输入",null);
        }
    }

    @RequestMapping("delete_judge")
    @ResponseBody
    public String delete_judge(){
        return "";
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public StatusJson delete_batch(@RequestParam("ids")int[] ids){
        if(ids!=null) {
            boolean flag = requirementService.deleteBatch(ids);
            if(flag ){
                return new StatusJson("200","OK",null);
            }else {
                return new StatusJson("0","删除失败",null);
            }
        }else {
            return new StatusJson("0","输入有误，请重新输入",null);
        }
    }


    /**
     * 通过id查询数据
     * @param searchValue  所输入的数据
     * @param page
     * @param rows
     * @return 查询到的数据
     */
    @RequestMapping("search_technology_by_technologyId")
    @ResponseBody
    public List<Technology> search_technology_by_technologyId(String  searchValue, Integer page,@Param("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Technology> technologies = requirementService.searchByPrimaryKey(searchValue, page, rows);
        return technologies;
    }

    /**
     *  通过name查询数据
     * @param searchValue
     * @param page
     * @param rows
     * @return 返回查询到的数据
     */
    @RequestMapping("search_technology_by_technologyName")
    @ResponseBody
    public List<Technology> searchTechnologyByTechnologyName(@RequestParam("searchValue")String  searchValue,@Param("page") Integer page,@Param("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Technology> technologies = requirementService.searchByName(searchValue, page, rows);
        return technologies;
    }
}
