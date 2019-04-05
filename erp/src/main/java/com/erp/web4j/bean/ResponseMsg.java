package com.erp.web4j.bean;

import java.io.Serializable;

/**
 * ClassName: ResponseMsg
 * Description:
 *
 * @author mighty
 * @version 1.0
 * @date 2019/4/4  15:37
 */
public class ResponseMsg implements Serializable {
    private static final long serialVersionUID = -5872917581716806078L;
    private String msg;
    private Integer status;
    private String data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }



    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseMsg{" +
                "msg='" + msg + '\'' +
                ", status=" + status +
                ", data='" + data + '\'' +
                '}';
    }
}
