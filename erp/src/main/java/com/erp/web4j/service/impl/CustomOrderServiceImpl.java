package com.erp.web4j.service.impl;


import com.erp.web4j.bean.CustomOrder;
import com.erp.web4j.mapper.CustomOrderMapper;
import com.erp.web4j.service.CustomOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/3 Time 20:41
 */
@Service
public class CustomOrderServiceImpl implements CustomOrderService {
    @Autowired
    CustomOrderMapper customOrderMapper;

    /**
     * 在service层将 页码转成数据库偏移量，直接调用接口
     * @param page 页码
     * @param rows 每页行数
     * @return CustomOrder的List，没有限制条件
     */
    @Override
    public List<CustomOrder> listOrders(Integer page, Integer rows) {
        return customOrderMapper.listOrders((page-1)*rows,rows);
    }

    @Override
    public int countOrderRecords() {
        return customOrderMapper.countOrderRecords();
    }

    @Override
    public int insert(CustomOrder customOrder) {
        return customOrderMapper.insertSelective(customOrder);
    }

    @Override
    public int deleteCustomOrderByIds(int[] ids) {
        return customOrderMapper.deleteByIds(ids);
    }

    @Override
    public int updateCustomOrderByPrimaryKey(CustomOrder customOrder) {
        return customOrderMapper.updateByPrimaryKey(customOrder);
    }

    @Override
    public List<CustomOrder> listOrdersById(String id, Integer page, Integer rows) {

        return customOrderMapper.listOrdersById("%"+id+"%",(page-1)*rows,rows);
    }

    @Override
    public Integer countOrderRecordsById(String searchValue) {
        return customOrderMapper.countOrderRecordsById("%"+searchValue+"%");
    }

    @Override
    public List<CustomOrder> listOrdersByCustomName(String searchValue, Integer page, Integer rows) {
        return customOrderMapper.listOrdersByCustomName("%"+searchValue+"%",(page-1)*rows,rows);
    }

    @Override
    public Integer countOrderRecordsByCustomName(String searchValue) {
        return customOrderMapper.countOrderRecordsByCustomName("%"+searchValue+"%");
    }

    @Override
    public Integer countOrderRecordsByProductName(String searchValue) {
        return customOrderMapper.countOrderRecordsByProductName("%"+searchValue+"%");
    }

    @Override
    public List<CustomOrder> listOrdersByProductName(String searchValue, Integer page, Integer rows) {
        return customOrderMapper.listOrdersByProductName("%"+searchValue+"%",(page-1)*rows,rows);
    }

    @Override
    public CustomOrder selectCustomById(String orderId) {
        return customOrderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public List<CustomOrder> listAllOrders() {
        return customOrderMapper.listAllOrders();
    }
}
