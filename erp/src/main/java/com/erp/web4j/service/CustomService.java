package com.erp.web4j.service;

import com.erp.web4j.bean.Custom;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/4 Time 13:58
 */
public interface CustomService {
    List<Custom> listAllCustoms();

    Integer countAllCustomRecords();

    List<Custom> listAllCustomsWithPageAndRows(int page, int rows);

    int addCustom(Custom custom);

    boolean checkCustomId(String customId);

    int updateCustomById(Custom custom);

    int deleteCustomByIds(String[] ids);

    List<Custom> listCustomsByCustomId(String searchValue, Integer page, Integer rows);

    Integer countCustomRecordsByCustomId(String searchValue);

    List<Custom> listCustomsByCustomName(String searchValue, Integer page, Integer rows);

    Integer countCustomRecordsByCustomName(String searchValue);

    Custom selectCustomByCustomId(String customId);
}
