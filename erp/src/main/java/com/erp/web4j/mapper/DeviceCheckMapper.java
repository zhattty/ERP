package com.erp.web4j.mapper;

import com.erp.web4j.bean.DeviceCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceCheckMapper {
    int deleteByPrimaryKey(String deviceCheckId);

    int insert(DeviceCheck record);

    int insertSelective(DeviceCheck record);

    DeviceCheck selectByPrimaryKey(String deviceCheckId);

    int updateByPrimaryKeySelective(DeviceCheck record);

    int updateByPrimaryKey(DeviceCheck record);
    List<DeviceCheck>  selectAllDeviceCheck();
    int deleteDeviceCheck(@Param("ids") String[] ids);
    List<DeviceCheck> toSearchDeviceCheckById(String searchValue);
    List<DeviceCheck> toSearchDeviceCheckByDeviceName(String searchValue);
    List<DeviceCheck> toSearchDeviceCheckByDeviceId(String deviceId);



}