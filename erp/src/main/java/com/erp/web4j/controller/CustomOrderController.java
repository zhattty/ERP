package com.erp.web4j.controller;

import com.erp.web4j.bean.CustomOrder;
import com.erp.web4j.bean.QueryVo;
import com.erp.web4j.bean.StatusJson;
import com.erp.web4j.service.CustomOrderService;
import com.erp.web4j.util.FilePathHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/3 Time 20:07
 */


@Controller
@RequestMapping("order")
public class CustomOrderController {
    @Autowired
    CustomOrderService customOrderService;

    @RequestMapping("find")
    public  String findOrder(){
        return "order_list";
    }

    @RequestMapping(value = "list")
    @ResponseBody()
    public QueryVo<CustomOrder> listOrder(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        Integer records = customOrderService.countOrderRecords();
        List<CustomOrder> customOrders = customOrderService.listOrders(page, rows);
        QueryVo<CustomOrder> customOrderQueryVo = new QueryVo<>();
        customOrderQueryVo.setRows(customOrders);
        customOrderQueryVo.setTotal(records);
        System.out.println(customOrderQueryVo);
        return customOrderQueryVo;
    }

    @RequestMapping("add_judge")
    @ResponseBody
    public String add_judge(){
        return "{}";
    }

    @RequestMapping("add")
    public String addOrder(){
        return "order_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public StatusJson insertCustomOrder(CustomOrder customOrder)  {
        StatusJson statusJson = new StatusJson();
        int insert = customOrderService.insert(customOrder);
        if (insert == 1){
            statusJson.setStatus("200");

        }else {
            statusJson.setMsg("插入失败，请更换订单号重试");
        }
        return statusJson;
    }

    @RequestMapping("edit")
    public String editCustomOrder(){
        return "order_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public StatusJson updateCustomOrderByPrimaryKey(CustomOrder customOrder){
        StatusJson statusJson = new StatusJson();
        int insert = customOrderService.updateCustomOrderByPrimaryKey(customOrder);
        if (insert == 1){
            statusJson.setStatus("200");
        }else {
            statusJson.setMsg("更新失败，请更换订单号重试");
        }
        return statusJson;
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public StatusJson deleteCustomOrderByIds(@RequestParam("ids") int[] ids){
        StatusJson statusJson = new StatusJson();
        if (ids == null || ids.length == 0){
            statusJson.setMsg("请勾选需要删除的对象");
            return statusJson;
        }
        int count = customOrderService.deleteCustomOrderByIds(ids);
        if (count == ids.length){
            statusJson.setStatus("200");
        }else if (count>0 && count<ids.length){
            statusJson.setMsg("部分删除不成功请重试");
        }else {
            statusJson.setMsg("删除失败");
        }
        return statusJson;
    }

    @RequestMapping(value = {"search_order_by_orderId"})
    @ResponseBody
    public QueryVo<CustomOrder> searchOrderById(String searchValue,
                                            @RequestParam("page") Integer page,
                                            @RequestParam("rows") Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        Integer records = customOrderService.countOrderRecordsById(searchValue);
        List<CustomOrder> customOrders = customOrderService.listOrdersById(searchValue,page, rows);
        QueryVo<CustomOrder> customOrderQueryVo = new QueryVo<>();
        customOrderQueryVo.setRows(customOrders);
        customOrderQueryVo.setTotal(records);
        System.out.println(customOrderQueryVo);
        return customOrderQueryVo;
    }
    @RequestMapping("search_order_by_orderCustom")
    @ResponseBody
    public QueryVo<CustomOrder> searchOrderByCustomName(String searchValue,
                                                        @RequestParam("page") Integer page,
                                                        @RequestParam("rows") Integer rows) {
        if (page == null || page <= 0) {
            page = 1;
        }
        if (rows <= 0) {
            rows = 10;
        }
        Integer records = customOrderService.countOrderRecordsByCustomName(searchValue);
        List<CustomOrder> customOrders = customOrderService.listOrdersByCustomName(searchValue, page, rows);
        QueryVo<CustomOrder> customOrderQueryVo = new QueryVo<>();
        customOrderQueryVo.setRows(customOrders);
        customOrderQueryVo.setTotal(records);
        System.out.println(customOrderQueryVo);
        return customOrderQueryVo;
    }

    @RequestMapping("search_order_by_orderProduct")
    @ResponseBody
    public QueryVo<CustomOrder> searchOrderByProductName(String searchValue,
                                                        @RequestParam("page") Integer page,
                                                        @RequestParam("rows") Integer rows) {
        if (page == null || page <= 0) {
            page = 1;
        }
        if (rows <= 0) {
            rows = 10;
        }
        Integer records = customOrderService.countOrderRecordsByProductName(searchValue);
        List<CustomOrder> customOrders = customOrderService.listOrdersByProductName(searchValue, page, rows);
        QueryVo<CustomOrder> customOrderQueryVo = new QueryVo<>();
        customOrderQueryVo.setRows(customOrders);
        customOrderQueryVo.setTotal(records);
        System.out.println(customOrderQueryVo);
        return customOrderQueryVo;
    }
}
