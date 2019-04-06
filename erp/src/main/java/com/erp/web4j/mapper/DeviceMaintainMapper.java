package com.erp.web4j.mapper;

import com.erp.web4j.bean.DeviceMaintain;

import java.util.List;

public interface DeviceMaintainMapper {
    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(DeviceMaintain record);

    int insertSelective(DeviceMaintain record);

    DeviceMaintain selectByPrimaryKey(String deviceMaintainId);

    int updateByPrimaryKeySelective(DeviceMaintain record);

    int updateByPrimaryKey(DeviceMaintain record);
    List<DeviceMaintain> findAllDeviceMaintain();
    int deleteDeviceMaintain(String[] ids);
    List<DeviceMaintain> searchDeviceMaintain(String searchValue);
    List<DeviceMaintain> toSearchDeviceMaintainByDeviceFaultId(String searchValue);

}