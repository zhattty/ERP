package com.erp.web4j.service.impl;

import com.erp.web4j.bean.Manufacture;
import com.erp.web4j.mapper.ManufactureMapper;
import com.erp.web4j.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/5 Time 17:38
 */
@Service
public class ManufactureServiceImpl implements ManufactureService {
    @Autowired
    ManufactureMapper manufactureMapper;

    @Override
    public List<Manufacture> listPageManufacture(Integer page, Integer rows) {
        return manufactureMapper.listPageManufacture((page - 1) * rows, rows);
    }

    @Override
    public int countAllManufactureRecords() {
        return manufactureMapper.countAllManufactureRecords();
    }

    @Override
    public int updateManufactureById(Manufacture manufacture) {
        return manufactureMapper.updateByPrimaryKey(manufacture);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    @Override
    public int deleteByIds(String[] ids) {
        return manufactureMapper.deleteByIds(ids);
    }

    @Override
    public List<Manufacture> listPageManufactureBySn(String searchValue, Integer page, Integer rows) {
        return manufactureMapper.listPageManufactureBySn("%" + searchValue + "%", (page - 1) * rows, rows);
    }

    @Override
    public int countAllManufactureRecordsBySn(String searchValue) {
        return manufactureMapper.countManufactureRecordsBySn("%" + searchValue + "%");
    }

    @Override
    public List<Manufacture> listPageManufactureByOrderId(String searchValue, Integer page, Integer rows) {
        return manufactureMapper.listPageManufactureByOrderId("%" + searchValue + "%", (page - 1) * rows, rows);
    }

    @Override
    public int countAllManufactureRecordsByOrderId(String searchValue) {
        return manufactureMapper.countManufactureRecordsByOrderId("%" + searchValue + "%");
    }

    @Override
    public List<Manufacture> listPageManufactureByTechnologyName(String searchValue, Integer page, Integer rows) {
        return manufactureMapper.listPageManufactureByTechnologyName("%" + searchValue + "%", (page - 1) * rows, rows);
    }

    @Override
    public int countAllManufactureRecordsByTechnologyName(String searchValue) {
        return manufactureMapper.countManufactureRecordsByTechnologyName("%" + searchValue + "%");
    }

    @Override
    public int insertManufacture(Manufacture manufacture) {
        return manufactureMapper.insertSelective(manufacture);
    }

    @Override
    public Manufacture selectManufactureBySn(String sn) {
        return manufactureMapper.selectBySn(sn);
    }

    @Override
    public List<Manufacture> listManufacture() {
        return manufactureMapper.listManufacture();
    }
}
