package com.erp.web4j.service;

import com.erp.web4j.bean.Material;

import java.util.Map;

/**
 * ClassName: MaterialService
 * Description:
 *
 * @author mighty
 * @version 1.0
 * @date 2019/4/3  22:34
 */
public interface MaterialService {

    /***
     * 添加一个material
     * @param material
     * @return
     */
    boolean addMaterial(Material material);

    /**
     * 分页显示所有的material
     * @param pageNum
     * @param pageSize
     * @return
     */
    Map<String, Object> listMaterialByPage(Integer pageNum, Integer pageSize);


}
