package com.erp.web4j.mapper;

import com.erp.web4j.bean.Device;
import com.erp.web4j.bean.DeviceType;

import java.util.List;

public interface DeviceMapper {
    int deleteByPrimaryKey(String deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(String deviceId);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
    List<Device> findDeviceList();
    List<Device> selectByPrimaryKeyGetList(String deviceId);
    Device selectDeviceByDeviceName(String deviceName);
    List<Device> selectByDeviceTypeNameGetList(String deviceTypeName);


}