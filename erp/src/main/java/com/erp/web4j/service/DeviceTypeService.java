package com.erp.web4j.service;

import com.erp.web4j.bean.DeviceType;

import java.util.List;

public interface DeviceTypeService {
   public List<DeviceType> selectAllDevice();
   public boolean insert(DeviceType record);
   boolean updateByPrimaryKey(DeviceType deviceType);
   boolean deleteByPrimaryKey(String[] deviceTypeIds);
   List<DeviceType> toSearchDeviceTypeList(String searchvalue);
   List<DeviceType> searchDeviceTypeName(String diviceTypeName);


}
