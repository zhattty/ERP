package com.erp.web4j.service;

import com.erp.web4j.bean.CustomOrder;
import com.erp.web4j.bean.TechnologyRequirement;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/4 Time 10:10
 */
public interface TechnologyRequirementService {
    List<TechnologyRequirement> listOrders(Integer page, Integer rows);

    int countOrderRecords();

}
