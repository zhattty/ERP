package com.erp.web4j.mapper;

import com.erp.web4j.bean.DeviceType;

import java.util.List;

public interface DeviceTypeMapper {
    int deleteByPrimaryKey(String deviceTypeId);

    int insert(DeviceType record);

    int insertSelective(DeviceType record);

    DeviceType selectByPrimaryKey(String deviceTypeId);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateByPrimaryKey(DeviceType record);

    List<DeviceType> selectAllDevice();

    List<DeviceType> toSearchDeviceTypeList(String searchvalue);

    List<DeviceType> searchDeviceTypeName(String diviceTypeName);



}