package com.erp.web4j.service;

import com.erp.web4j.bean.Manufacture;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/5 Time 17:37
 */
public interface ManufactureService {
    List<Manufacture> listPageManufacture(Integer page, Integer rows);

    int countAllManufactureRecords();

    int updateManufactureById(Manufacture manufacture);

    int deleteByIds(String[] ids);

    List<Manufacture> listPageManufactureBySn(String searchValue, Integer page, Integer rows);

    int countAllManufactureRecordsBySn(String searchValue);

    List<Manufacture> listPageManufactureByOrderId(String searchValue, Integer page, Integer rows);

    int countAllManufactureRecordsByOrderId(String searchValue);

    List<Manufacture> listPageManufactureByTechnologyName(String searchValue, Integer page, Integer rows);

    int countAllManufactureRecordsByTechnologyName(String searchValue);

    int insertManufacture(Manufacture manufacture);

    Manufacture selectManufactureBySn(String sn);

    List<Manufacture> listManufacture();
}
