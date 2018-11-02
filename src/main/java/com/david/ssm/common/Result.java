package com.david.ssm.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.context.request.async.DeferredResult;

import java.io.Serializable;

public class Result implements Serializable {
    private static final long serialVersionUID = 831462060779424615L;

    public static final int CODE_SUCCESS_DEFAULT = 0;
    public static final int CODE_ERROR_DEFAULT = -1;

    private int code;
    private String msg = "success";
    private Object data;

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data != null ? data : null;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code) {
        this.code = code;
    }

    public static Result error() {
        return new Result(CODE_ERROR_DEFAULT);
    }

    public static Result error(String msg) {
        return new Result(CODE_ERROR_DEFAULT, msg);
    }

    public static Result error(int code) {
        return new Result(code);
    }

    public static Result error(int code, String msg) {
        return new Result(code, msg);
    }

    public static Result error(int code, String msg, Object data) {
        return new Result(code, msg, data);
    }

    public static Result success(int code, String msg, Object data) {
        return new Result(code, msg, data);
    }

    public static Result success(String msg, Object data) {
        return new Result(CODE_SUCCESS_DEFAULT, msg, data);
    }

    public static Result success(String msg) {
        return new Result(CODE_SUCCESS_DEFAULT, msg);
    }

    public static Result success(Object data) {
        return new Result(CODE_SUCCESS_DEFAULT, "", data);
    }

    public static Result success() {
        return new Result(CODE_SUCCESS_DEFAULT);
    }

    public static DeferredResult<Result> buildDeferredResult(Result r) {
        DeferredResult<Result> deferredResult = new DeferredResult<>();
        deferredResult.setResult(r);
        return deferredResult;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return CODE_SUCCESS_DEFAULT == getCode();
    }

}
