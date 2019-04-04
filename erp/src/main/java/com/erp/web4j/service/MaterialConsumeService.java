package com.erp.web4j.service;

import com.erp.web4j.bean.MaterialConsume;

import java.util.Map;

/**
 * ClassName: MaterialConsumeService
 * Description:
 *
 * @author mighty
 * @version 1.0
 * @date 2019/4/4  23:59
 */
public interface MaterialConsumeService {
    boolean addMaterialConsume(MaterialConsume materialConsume);

    Map<String, Object> listMaterialConsumeByPage(Integer pageNum, Integer pageSize);

    Map<String, Object> searchMaterialConsumeBymaterialId(String searchValue, Integer pageNum, Integer pageSize);

    Map<String, Object> searchMaterialConsumeByConsumeId(String searchValue, Integer pageNum, Integer pageSize);

    boolean deleteMaterialConsume(String[] ids);

    boolean updateMaterialConsume(MaterialConsume materialConsume);
}
