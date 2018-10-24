package com.example.mybatis.util;

/**
 * @author rick
 */
public enum StatusCode {
    /**
     * 操作成功
     */
    SUCCESS("操作成功","00000"),

    /**
     * 不存在
     */
    NOT_FOUND("不存在的对象","00001"),

    /**
     * 已存在
     */
    HAVE_EXISTE("已存在对象", "00002"),

    /**
     * 未知错误
     */
    SOME_ERROR("未知错误","50000");


    private String message;
    private String code;

    StatusCode(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
