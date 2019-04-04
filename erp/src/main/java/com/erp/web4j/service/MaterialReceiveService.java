package com.erp.web4j.service;

import com.erp.web4j.bean.MaterialReceive;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * ClassName: MaterialReceiveService
 * Description:
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
    Map<String, Object> listMaterialReceiveByPage(Integer pageNum, Integer pageSize);

    boolean deleteMaterialReceives(@Param("ids") String[] ids);

    boolean updateMaterialReceive(MaterialReceive materialReceive);

    Map<String, Object> searchMaterialReceiveBymaterialId(String materialId, Integer pageNum, Integer pageSize);

    Map<String, Object> searchMaterialReceiveByReceiveId(String receiveId, Integer pageNum, Integer pageSize);

}
