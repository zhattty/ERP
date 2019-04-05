package com.erp.web4j.service;

import com.erp.web4j.bean.Material;

import java.util.List;
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
     * 分页查询所有的material
     * @param pageNum
     * @param pageSize
     * @return
     */
    Map<String, Object> listMaterialByPage(Integer pageNum, Integer pageSize);

    /**
     * 根据id批量删除materials
     * @return
     */
    boolean deleteMaterials(String[] ids);


    /**
     * 修改material
     * @param material
     * @return
     */
    boolean updateMaterial(Material material);

    /**
     * 根据id查询并分页
     * @param searchValue
     * @param pageNum
     * @param pageSize
     * @return
     */
    Map<String, Object> searchMaterialById(String searchValue, Integer pageNum, Integer pageSize);

    /***
     * 根据type查询并分页
     * @param searchValue
     * @param pageNum
     * @param pageSize
     * @return
     */
    Map<String, Object> searchMaterialByType(String searchValue, Integer pageNum, Integer pageSize);

    Material getMaterial(String materialId);


    List<Material> selectAllMaterials();


}
