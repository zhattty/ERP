package com.erp.web4j.service;

import com.erp.web4j.bean.MaterialConsume;

import java.util.List;

/**
 * ClassName: MaterialConsumeService
 * Description:
 *
 * @author mighty
 * @version 1.0
 * @date 2019/4/4  23:59
 */
public interface MaterialConsumeService {
    /**
     * 新增
     * @param materialConsume
     * @return
     */
    boolean addMaterialConsume(MaterialConsume materialConsume);

    /**
     * 查询 所有
     * @param consumeId
     * @return
     */
    MaterialConsume findMaterialConsume(String consumeId);

    /**
     * 分页 查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<MaterialConsume> listMaterialConsumeByPage(Integer pageNum, Integer pageSize);

    /**
     * 查询 条件：物料信息编号
     * @param searchValue
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<MaterialConsume> searchMaterialConsumeBymaterialId(String searchValue, Integer pageNum, Integer pageSize);

    /**
     * 查询 条件：物料消耗信息编号
     * @param searchValue
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<MaterialConsume> searchMaterialConsumeByConsumeId(String searchValue, Integer pageNum, Integer pageSize);

    /**
     * 查询 条件：物料消耗信息编号
     * @param searchValue
     * @param pageNum
     * @param pageSize
     * @return
     */


    List<MaterialConsume> searchMaterialConsumeByWorkId(String searchValue, Integer pageNum, Integer pageSize);
    /**
     * 批量删除
     * @param ids
     * @return
     */
    boolean deleteMaterialConsume(String[] ids);

    /**
     * 更新
     * @param materialConsume
     * @return
     */
    boolean updateMaterialConsume(MaterialConsume materialConsume);




}
