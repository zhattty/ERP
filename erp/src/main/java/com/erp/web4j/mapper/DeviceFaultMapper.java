package com.erp.web4j.mapper;

import com.erp.web4j.bean.DeviceFault;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceFaultMapper {
    int deleteByPrimaryKey(String deviceFaultId);

    int insert(DeviceFault record);

    int insertSelective(DeviceFault record);

    DeviceFault selectByPrimaryKey(String deviceFaultId);

    int updateByPrimaryKeySelective(DeviceFault record);

    int updateByPrimaryKey(DeviceFault record);
    List<DeviceFault> selectAllDeviceFault();
    int deleteDeviceFault(@Param("ids") String[] ids);
    List<DeviceFault> searchDeviceFault(String deviceFaultId);
    List<DeviceFault> searchDeviceFaultByDeviceName(String deviceName);

}