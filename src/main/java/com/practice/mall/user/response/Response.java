package com.practice.mall.user.response;

import com.practice.mall.user.enums.ResultCodeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class Response<T> implements Serializable {
    private String code = ResultCodeEnum.GLOBAL_SUCCESS.getCode();

    private String msg;

    private T dto;

    public Response() {

    }

    public Response(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(T dto) {
        this.dto = dto;
    }

    public Response(String code, String msg, T dto) {
        this.code = code;
        this.msg = msg;
        this.dto = dto;
    }
}
