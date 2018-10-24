package com.example.mybatis.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author rick
 */
@Data
public class ObjectRestResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String message;

    private T data;


    public ObjectRestResponse(StatusCode status, T data){
        this.code = status.getCode();
        this.message = status.getMessage();
        this.data = data;
    }

    public ObjectRestResponse(StatusCode status){
        this.code = status.getCode();
        this.message = status.getMessage();
        this.data = null;
    }
}
