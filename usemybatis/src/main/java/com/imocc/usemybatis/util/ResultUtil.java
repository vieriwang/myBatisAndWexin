package com.imocc.usemybatis.util;


import com.imocc.usemybatis.util.enums.ResultEnum;
import com.imocc.usemybatis.util.objUtil.Result;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class ResultUtil {

    /**
     * 返回正确信息及对象集合
     *
     * @param obj
     * @return
     */
    public static Result success(Object obj) {
        Result r = new Result(ResultEnum.OPER_SUCCESS.getCode(), ResultEnum.OPER_SUCCESS.getMessage());
        r.setData(obj);
        return r;

    }

    /**
     * 返回正确的信息
     *
     * @return
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 返回错误信息。
     *
     * @param code
     * @param message
     * @return
     */
    public static Result error(Integer code, String message) {
        return new Result(code, message);
    }

    public static Result defaultError() {
        return new Result(ResultEnum.UNKNOW_ERROR.getCode(),ResultEnum.UNKNOW_ERROR.getMessage());
    }
}
