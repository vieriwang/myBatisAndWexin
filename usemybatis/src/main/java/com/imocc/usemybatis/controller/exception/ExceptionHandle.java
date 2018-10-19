package com.imocc.usemybatis.controller.exception;

import com.imocc.usemybatis.util.ResultUtil;
import com.imocc.usemybatis.util.exception.dao.AreaException;
import com.imocc.usemybatis.util.objUtil.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof AreaException) {
            AreaException areaException = (AreaException) e;
            return ResultUtil.error(areaException.getCode(), areaException.getMessage());
        }
        logger.error("系统异常 {}" ,e);
        return ResultUtil.defaultError();
    }
}
