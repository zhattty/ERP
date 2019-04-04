package com.erp.web4j.service;

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
    Map<String, Object> listMaterialByPage(Integer pageNum, Integer pageSize);
}
