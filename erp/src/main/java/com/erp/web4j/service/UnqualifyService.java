package com.erp.web4j.service;

import com.erp.web4j.bean.UnqualifyApply;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Yana
 * Date 2019/4/4 Time 11:20
 */
public interface UnqualifyService {

    ArrayList<UnqualifyApply> queryUnqualifyApply(Integer page, Integer rows);

    Integer countUnqualifyRecords();

    int insertUnqualifyApply(UnqualifyApply unqualifyApply);

    int updateUnqualifyApply(UnqualifyApply unqualifyApply);


    int deleteUnqualifyApply(int[] ids);

    int countUnqualifyRecordsById(String id);

    ArrayList<UnqualifyApply> listUnqualifyApply(String searchValue, Integer page, Integer rows);

    ArrayList<UnqualifyApply> listUnqualifyApplyByProductName(String searchValue, Integer page, Integer rows);

    int countUnqualifyRecordsByProductName(String searchValue);
}
