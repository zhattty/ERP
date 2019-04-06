package com.erp.web4j.service;

import com.erp.web4j.bean.MaterialReceive;

import java.util.List;

/**
 * ClassName: MaterialReceiveService
 * Description: 物料接收 service层的接口
 *
 * @author mighty
 * @version 1.0
 * @date 2019/4/4  19:55
 */
public interface MaterialReceiveService {
    /***
     * 增加
     * @param materialReceive
     * @return
     */
    boolean addMaterialReceive(MaterialReceive materialReceive);

    /**
     * 分页查询所有
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<MaterialReceive> listMaterialReceiveByPage(Integer pageNum, Integer pageSize);

    /**
     * 删除
     * @param ids
     * @return
     */
    boolean deleteMaterialReceives(String[] ids);

    /**
     * 更新
     * @param materialReceive
     * @return
     */
    boolean updateMaterialReceive(MaterialReceive materialReceive);

    /**
     * 查询 条件：物料信息编号
     * @param materialId
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<MaterialReceive> searchMaterialReceiveBymaterialId(String materialId, Integer pageNum, Integer pageSize);

    /***
     * 查询 条件：物料接收信息编号
     * @param receiveId
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<MaterialReceive> searchMaterialReceiveByReceiveId(String receiveId, Integer pageNum, Integer pageSize);

    /**
     * 查询 信息
     * @param receiveId
     * @return
     */
    MaterialReceive findMaterialReceive(String receiveId);
}
