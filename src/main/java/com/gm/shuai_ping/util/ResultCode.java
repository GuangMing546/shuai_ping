package com.gm.shuai_ping.util;

public enum ResultCode {
    /**
     * 成功状态码
     */
    SUCCESSLOGIN(200,"登录成功"),
    SUCCESSEXIT(201,"退出成功"),
    SUCCESS(202,"操作成功"),
    SUCCESSREGISTER(205,"注册成功"),

    FAILLogin(400,"登录失败"),
    FAILEXIT(401,"退出失败"),
    FAIL(402,"操作失败"),
    FAILREGISTER(405,"注册失败"),
    ALREADYLogin(406,"你已登录"),

    NOTOKEN(401,"你没有token，请先登录"),
    VERIFYTOKENFILE(402,"token验证失败");


    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


}
