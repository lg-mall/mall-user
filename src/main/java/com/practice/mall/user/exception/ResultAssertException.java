package com.practice.mall.user.exception;

public class ResultAssertException extends RuntimeException {

    private static final long serialVersionUID = -6529540380890032319L;

    private String code;


    public ResultAssertException() {

    }

    public ResultAssertException(String code, String message) {
        super(message);
        this.code = code;
    }

    public ResultAssertException(String code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
