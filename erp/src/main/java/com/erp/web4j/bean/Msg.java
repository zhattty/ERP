package com.erp.web4j.bean;

import java.io.Serializable;

/**
 * Created by ZhangYao
 * Date 2019/4/3 Time 23:05
 */
public class Msg implements Serializable {
    private static final long serialVersionUID = -5872917581716806078L;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
