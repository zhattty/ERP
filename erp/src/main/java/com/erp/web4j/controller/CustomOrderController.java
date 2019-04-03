package com.erp.web4j.controller;

import com.erp.web4j.bean.CustomOrder;
import com.erp.web4j.bean.QueryVo;
import com.erp.web4j.service.CustomOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
