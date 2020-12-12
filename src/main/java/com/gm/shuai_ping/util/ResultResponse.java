package com.gm.shuai_ping.util;

public class ResultResponse {

    private Integer code;
    private String message;
    private Object ObjData;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObjData() {
        return ObjData;
    }

    public void setObjData(Object objData) {
        ObjData = objData;
    }
}
