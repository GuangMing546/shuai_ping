package com.gm.shuai_ping.util;

public enum ResultCode {
    /**
     * 成功状态码
     */
    SUCCESSLOGIN(200,"登录成功"),
    FAILLogin(400,"登录失败"),
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
