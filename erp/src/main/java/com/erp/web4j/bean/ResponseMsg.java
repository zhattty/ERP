package com.erp.web4j.bean;

import java.io.Serializable;

/**
 * ClassName: ResponseMsg
 * Description: 返回信息类
 *
 * @author mighty
 * @version 1.0
 * @date 2019/4/4  15:37
 */
public class ResponseMsg implements Serializable {
    private static final long serialVersionUID = -5872917581716806078L;
    /**
     * 返回的信息
     */
    private String msg;

    /**
     * 返回的状态码
     */
    private Integer status;

    /**
     * 返回的数据
     */
    private String data;
    /**
     * 状态标识
     */
    public static ResponseMsg OK = new ResponseMsg(200,"成功", null);
    public static ResponseMsg FAIL = new ResponseMsg(null,"操作失败，请重试",null);


    public ResponseMsg() {
    }

    public ResponseMsg(Integer status, String msg, String data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

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
