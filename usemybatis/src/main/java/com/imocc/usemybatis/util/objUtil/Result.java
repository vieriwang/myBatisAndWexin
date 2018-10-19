package com.imocc.usemybatis.util.objUtil;

import com.imocc.usemybatis.util.enums.ResultEnum;

/**
 * HTTP请求返回的对象
 *
 * @param <T>
 */
public class Result<T> {
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 信息
     */
    private String message;

    /**
     * 具体的内容
     */
    private T data;

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
