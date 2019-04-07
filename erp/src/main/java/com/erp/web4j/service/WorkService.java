package com.erp.web4j.service;

import com.erp.web4j.bean.Work;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/5 Time 10:11
 */
public interface WorkService {
    List<Work> listPageWork(Integer page, Integer rows);

    int countAllRecords();

    int updateWorkById(Work work);

    int deleteWorkByIds(String[] ids);

    List<Work> searchWorkById(String searchValue, Integer page, Integer rows);

    int countWorkRecordsById(String searchValue);

    List<Work> searchWorkByProcessId(String searchValue, Integer page, Integer rows);

    int countWorkRecordsByProcessId(String searchValue);

    List<Work> searchWorkByProductName(String searchValue, Integer page, Integer rows);

    int countWorkRecordsByProductName(String searchValue);

    List<Work> searchWorkByDeviceName(String searchValue, Integer page, Integer rows);

    int countWorkRecordsByDeviceName(String searchValue);

    Work selectWorkById(String workId);

    List<Work> listWork();

    boolean checkWorkId(String workId);

    int insertWork(Work work);
}
