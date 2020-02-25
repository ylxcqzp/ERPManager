package com.example.erp.entity;


/**
 * @author qzp
 * @date 2020/2/13
 */
public class RespMes {
    private Integer status;
    private String msg;
    private Object obj;
    public static RespMes build() {
        return new RespMes();
    }

    public static RespMes ok(String msg) {
        return new RespMes(200, msg, null);
    }

    public static RespMes ok(String msg, Object obj) {
        return new RespMes(200, msg, obj);
    }

    public static RespMes error(String msg) {
        return new RespMes(500, msg, null);
    }

    public static RespMes error(String msg, Object obj) {
        return new RespMes(500, msg, obj);
    }

    private RespMes() {
    }

    private RespMes(Integer status, String msg, Object obj) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    public Integer getStatus() {
        return status;
    }

    public RespMes setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RespMes setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getObj() {
        return obj;
    }

    public RespMes setObj(Object obj) {
        this.obj = obj;
        return this;
    }
}
