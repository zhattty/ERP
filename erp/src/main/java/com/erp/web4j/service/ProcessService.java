package com.erp.web4j.service;

import com.erp.web4j.bean.Process;
import com.erp.web4j.bean.Technology;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/5 Time 16:21
 */
public interface ProcessService {
    Integer countOrderRecords();

    List<Process> searchByPrimaryKey(Integer page, Integer rows);

    boolean insert(Process process);

    boolean update(Process process);

    boolean deleteBatch(int[] ids);

    List<Process> searchByPrimaryKey2(String searchValue, Integer page, Integer rows);

    List<Process> searchByTechnologyId(String searchValue, Integer page, Integer rows);
}
