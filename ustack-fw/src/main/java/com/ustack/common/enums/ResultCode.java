package com.ustack.common.enums;

/**
 * Description: ResultCode
 *
 * @author Ferris
 * @Version 1.0
 */
public enum ResultCode {

    // 成功
    SUCCESS(0,"成功"),

    // 失败
    FAIL(-1,"失败"),

    PARAM_ERROR(-10,"参数验证失败"),

    BUSINESS_ERROR(-20,"业务异常"),

    SYSTEM_ERROR(-30,"业务异常"),

    ;

    public int code;
    public String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}


