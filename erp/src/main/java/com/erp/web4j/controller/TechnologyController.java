package com.erp.web4j.controller;

import com.erp.web4j.bean.StatusJson;
import com.erp.web4j.bean.Technology;
import com.erp.web4j.service.TechnologyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/3 Time 18:00
 */
@Controller
@RequestMapping("technology")
class TechnologyController {
    @Autowired
            @Qualifier(value = "technologyService")
    TechnologyService technologyService;


    /**
     *
     *
     * @return technology.jsp
     */
    @RequestMapping("find")
    public String  find(){
        return "technology_list";
    }

    /**
     * 分页并返回分页查询后的数据
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public List<Technology> list(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows){

        List<Technology> technologyList = technologyService.findTechnology(page, rows);
        return technologyList;
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
        List<Technology> technologies = technologyService.searchByPrimaryKey(searchValue, page, rows);
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
    public List<Technology> search_technology_by_technologyName(@RequestParam("searchValue")String  searchValue,@Param("page") Integer page,@Param("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Technology> technologies = technologyService.searchByName(searchValue, page, rows);
        return technologies;
    }

    @RequestMapping("add_judge")
    @ResponseBody
    public String add_judge(){
        return "";
    }

    @RequestMapping("add")
    public String add(Technology technology){
        return "technology_add";
    }

    /**
     * 接收前端传输的technology对象，返回查询结果的StatusJson
     * @param technology
     * @return 插入的结果json
     */
    @RequestMapping("insert")
    @ResponseBody
    public StatusJson insert(Technology technology){
        //StatusJson statusJson = new StatusJson();
        if(technology!=null) {
            boolean flag = technologyService.insert(technology);
            if(flag ){
                return new StatusJson("200","OK",null);
            }else {
                return new StatusJson("0","该工艺编号已经存在，请更换工艺编号！",null);
            }
        }else {
            return new StatusJson("0","输入有误，请重新输入",null);
        }
    }

    @RequestMapping("edit_judge")
    @ResponseBody
    public String edit_judge(){
        return "";
    }

    @RequestMapping("edit")
    public String edit(){
        return "technology_edit";
    }

    /**
     * 更新数据库
     * @param technology
     * @return
     */
    @RequestMapping("update_all")
    @ResponseBody
    public StatusJson update_all(Technology technology){
        if(technology!=null) {
            boolean flag = technologyService.update(technology);
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

    /**
     * 批量删除
     * @param ids 前端传输过来的数据
     * @return  StatusJson
     */
    @RequestMapping("delete_batch")
    @ResponseBody
    public StatusJson delete_batch(@RequestParam("ids")int[] ids){
        if(ids!=null) {
            boolean flag = technologyService.deleteBatch(ids);
            if(flag ){
                return new StatusJson("200","OK",null);
            }else {
                return new StatusJson("0","删除失败",null);
            }
        }else {
            return new StatusJson("0","输入有误，请重新输入",null);
        }
    }

    @RequestMapping("get/{technologyName}")
    @ResponseBody
    public Technology selectTechnologyById(@PathVariable String technologyName){
        Technology technology = technologyService.selectTechnologyById(technologyName);
        System.out.println(technology);
        return technology;

    }
}
