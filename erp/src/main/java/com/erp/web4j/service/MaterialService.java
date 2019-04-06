package com.erp.web4j.service;

import com.erp.web4j.bean.Material;
import com.erp.web4j.bean.QueryVo;

import java.util.List;

/**
 * ClassName: MaterialService
 * Description: 物料 service接口
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
    QueryVo<Material> listMaterialByPage(Integer pageNum, Integer pageSize);

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
    QueryVo<Material> searchMaterialById(String searchValue, Integer pageNum, Integer pageSize);

    /***
     * 根据type查询并分页
     * @param searchValue
     * @param pageNum
     * @param pageSize
     * @return
     */
    QueryVo<Material> searchMaterialByType(String searchValue, Integer pageNum, Integer pageSize);

    /**
     * 公共查询id接口
     * @param materialId
     * @return
     */
    Material getMaterial(String materialId);


    /**
     * 查询 所有
     * @return
     */
    List<Material> selectAllMaterials();


}
