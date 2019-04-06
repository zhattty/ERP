package com.erp.web4j.service;

import com.erp.web4j.bean.CustomOrder;
import com.erp.web4j.bean.Technology;
import com.erp.web4j.bean.TechnologyRequirement;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/4 Time 10:10
 */
public interface TechnologyRequirementService {
    /**
     *  查找所有的记录
     * @param page
     * @param rows
     * @return 记录所组成的List
     */
    List<TechnologyRequirement> listOrders(Integer page, Integer rows);

    /**
     * 计算所有的记录条数
     * @return
     */
    Integer countOrderRecords();

    /**
     * 插入一条数据
     * @param technologyRequirement
     * @return
     */
    boolean insert(TechnologyRequirement technologyRequirement);

    /**
     * 更新一条数据
     * @param technologyRequirement
     * @return
     */
    boolean update(TechnologyRequirement technologyRequirement);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    boolean deleteBatch(int[] ids);

    /**
     * 根据名称模糊匹配查找
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    List<TechnologyRequirement> searchByName(String searchValue, Integer page, Integer rows);

    /**
     * 根据主键查找
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    List<TechnologyRequirement> searchByPrimaryKey(String searchValue, Integer page, Integer rows);

    /*List<Technology> findTechnology(Integer page, Integer rows);*/
}
