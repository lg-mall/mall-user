package com.practice.mall.user.enums;

public enum ResultCodeEnum {
    //*********************************
    //*********  global
    //***********************************
    GLOBAL_SUCCESS("0", "successful"),
    GLOBAL_PARAM_ILLEGAL("100", "param illegal"),
    GLOBAL_FAIL_UNKNOWN("101", "fail unknown"),

    //*********************************
    //*********  register
    //***********************************
    REGISTER_MERCHANT_NAME_EXISTENCE("1001000102", "merchant name already exists"),

    ;
    private String code;

    private String description;

    ResultCodeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
