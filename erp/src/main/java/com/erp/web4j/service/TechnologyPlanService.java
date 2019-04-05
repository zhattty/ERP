package com.erp.web4j.service;

import com.erp.web4j.bean.Technology;
import com.erp.web4j.bean.TechnologyPlan;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/5 Time 13:15
 */
public interface TechnologyPlanService {

    /**
     * 查找所有的记录数
     * @return
     */
    Integer countOrderRecords();

    /**
     * 查找Technology_plan表中所有记录并返回
     * @param page
     * @param rows
     * @return
     */
    List<TechnologyPlan> listOrders(Integer page, Integer rows);

    /**
     * 插入一个数据
     * @param technologyPlan
     * @return 插入成功返回true 插入失败返回false
     */
    boolean insert(TechnologyPlan technologyPlan);

    /**
     * 更新一个数据
     * @param technologyPlan
     * @return 更新成功返回true 更新失败返回false
     */
    boolean update(TechnologyPlan technologyPlan);

    /**
     * 批量删除
     * @param ids
     * @return 删除的个数
     */
    boolean deleteBatch(int[] ids);

    List<TechnologyPlan> searchByPrimaryKey(String searchValue, Integer page, Integer rows);

    List<TechnologyPlan> searchByName(String searchValue, Integer page, Integer rows);
}
