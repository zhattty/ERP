package com.erp.web4j.service.impl;

import com.erp.web4j.bean.TechnologyRequirement;
import com.erp.web4j.mapper.TechnologyRequirementMapper;
import com.erp.web4j.service.TechnologyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/4 Time 10:11
 */
@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {

    @Autowired
    TechnologyRequirementMapper technologyRequirementMapper;

    /**
     * 在service层将 页码转成数据库偏移量，直接调用接口
     * @param page 页数
     * @param rows 行数
     * @return  CustomOrder的List，没有限制条件
     */
    @Override
    public List<TechnologyRequirement> listOrders(Integer page, Integer rows) {
        return technologyRequirementMapper.listOrders((page-1)*rows,rows);
    }

    /**
     * 统计该页面所有的记录数
     * @return
     */
    @Override
    public int countOrderRecords() {
        return technologyRequirementMapper.countOrderRecords();
    }
}
