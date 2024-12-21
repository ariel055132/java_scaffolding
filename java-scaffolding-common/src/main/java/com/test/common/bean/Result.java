package com.test.common.bean;

import com.test.common.enums.CodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 基本 Response Result 封装
 * @param <T>
 */

@Data
public class Result<T> implements Serializable {
    private Boolean success;

    private Integer code;

    private String msg;

    private T data;

    public Result() {
        this.success = true;
        this.code = CodeEnum.SUCCESS.getCode();
        this.msg = CodeEnum.SUCCESS.getMsg();
    }

    public Result(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result errorResult(int code, String msg) {
        Result result = new Result();
        return result.error(code, msg);
    }

    public static Result successResult() {
        Result result = new Result();
        return result;
    }

    public static Result successResult(int code, String msg) {
        Result result = new Result();
        return result.success(code, msg);
    }

    public static Result setCodeEnum(CodeEnum codeEnum) {
        return successResult(codeEnum.getCode(), codeEnum.getMsg());
    }

    public Result<?> success(T data) {
        this.success = true;
        this.data = data;
        return this;
    }

    /**
     * Setup success Result
     * @param code
     * @param data
     * @return
     */
    public Result<?> success(Integer code, T data) {
        this.success = true;
        this.code = code;
        this.data = data;
        return this;
    }

    public Result<?> success(Integer code, T data, String msg) {
        this.success = true;
        this.code = code;
        this.data = data;
        this.msg = msg;
        return this;
    }

    public Result<?> error(Integer code, String msg) {
        this.success = false;
        this.code = code;
        this.msg = msg;
        return this;
    }
}
