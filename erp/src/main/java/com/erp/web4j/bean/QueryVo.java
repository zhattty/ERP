package com.erp.web4j.bean;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/3 Time 21:50
 */
public class QueryVo <T>{
    Integer total;
    List<T> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
