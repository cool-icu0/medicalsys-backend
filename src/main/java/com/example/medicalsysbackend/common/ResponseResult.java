package com.example.medicalsysbackend.common;


//统一返回类
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> {
    private ErrorCode errorCode;
    private Integer code;
    private String msg;
    private T data;

    public ResponseResult(ErrorCode errorCode, T data) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMessage();
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(ErrorCode errorCode) {
        super();
        this.code = errorCode.getCode();
    }

    public ResponseResult() {
    }
}