package com.erp.web4j.controller;

import com.erp.web4j.bean.Manufacture;
import com.erp.web4j.bean.QueryVo;
import com.erp.web4j.bean.StatusJson;
import com.erp.web4j.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/5 Time 17:36
 */
@Controller
@RequestMapping("manufacture")
public class ManufactureController {
    @Autowired
    ManufactureService manufactureService;

    @RequestMapping("find")
    public String findManufactureList(){
        return "manufacture_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public QueryVo<Manufacture> listPageManufacture(@RequestParam("page")Integer page,
                                                    @RequestParam("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Manufacture> manufactures = manufactureService.listPageManufacture(page, rows);
        int records = manufactureService.countAllManufactureRecords();
        QueryVo<Manufacture> manufactureQueryVo = new QueryVo<>();
        manufactureQueryVo.setTotal(records);
        manufactureQueryVo.setRows(manufactures);
        return manufactureQueryVo;
    }

    @RequestMapping("add")
    public String showAddManufacture(){
        return "manufacture_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public StatusJson insertManufacture(Manufacture manufacture){
        StatusJson statusJson = new StatusJson();
        int result = manufactureService.insertManufacture(manufacture);
        if (result == 1){
            statusJson.setStatus("200");
        }else {
            statusJson.setMsg("更新失败，请更换订单号重试");
        }
        return statusJson;
    }

    @RequestMapping("edit")
    public String showEdit(){
        return "manufacture_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public StatusJson updateManufactureById(Manufacture manufacture){
        StatusJson statusJson = new StatusJson();
        int result = manufactureService.updateManufactureById(manufacture);
        if (result == 1){
            statusJson.setStatus("200");
        }else {
            statusJson.setMsg("更新失败，请更换订单号重试");
        }
        return statusJson;
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public StatusJson deleteByIds(@RequestParam("ids")String[] ids){
        StatusJson statusJson = new StatusJson();
        if (ids == null || ids.length == 0){
            statusJson.setMsg("请勾选需要删除的对象");
            return statusJson;
        }
        int count = manufactureService.deleteByIds(ids);
        if (count == ids.length){
            statusJson.setStatus("200");
        }else {
            statusJson.setMsg("删除失败");
        }
        return statusJson;
    }
    @RequestMapping("search_manufacture_by_manufactureSn")
    @ResponseBody
    public QueryVo<Manufacture> listPageManufactureBySn(String searchValue,
                                                        @RequestParam("page")Integer page,
                                                        @RequestParam("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Manufacture> manufactures = manufactureService.listPageManufactureBySn(searchValue, page, rows);
        int records = manufactureService.countAllManufactureRecordsBySn(searchValue);
        QueryVo<Manufacture> manufactureQueryVo = new QueryVo<>();
        manufactureQueryVo.setTotal(records);
        manufactureQueryVo.setRows(manufactures);
        return manufactureQueryVo;
    }

    @RequestMapping("search_manufacture_by_manufactureOrderId")
    @ResponseBody
    public QueryVo<Manufacture> listPageManufactureByOrderId(String searchValue,
                                                        @RequestParam("page")Integer page,
                                                        @RequestParam("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Manufacture> manufactures = manufactureService.listPageManufactureByOrderId(searchValue, page, rows);
        int records = manufactureService.countAllManufactureRecordsByOrderId(searchValue);
        QueryVo<Manufacture> manufactureQueryVo = new QueryVo<>();
        manufactureQueryVo.setTotal(records);
        manufactureQueryVo.setRows(manufactures);
        return manufactureQueryVo;
    }

    @RequestMapping("search_manufacture_by_manufactureTechnologyName")
    @ResponseBody
    public QueryVo<Manufacture> listPageManufactureByTechnologyName(String searchValue,
                                                        @RequestParam("page")Integer page,
                                                        @RequestParam("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Manufacture> manufactures = manufactureService.listPageManufactureByTechnologyName(searchValue, page, rows);
        int records = manufactureService.countAllManufactureRecordsByTechnologyName(searchValue);
        QueryVo<Manufacture> manufactureQueryVo = new QueryVo<>();
        manufactureQueryVo.setTotal(records);
        manufactureQueryVo.setRows(manufactures);
        return manufactureQueryVo;
    }

    @RequestMapping("get/{sn}")
    @ResponseBody
    public Manufacture selectManufactureBySn(@PathVariable String sn){
        return manufactureService.selectManufactureBySn(sn);
    }

    @RequestMapping("get_data")
    @ResponseBody
    public List<Manufacture> listManufacture(){
        return manufactureService.listManufacture();
    }
}
