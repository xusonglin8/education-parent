package com.education.servicebase.exceptionhandler;

import com.baomidou.mybatisplus.extension.api.R;
import com.education.commonutils.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xusonglin
 * @date 2020/10/17 - 10:45
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    //指定出现什么异常执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody //为了返回数据
    public RestResponse error(Exception e) {
        log.error(e.getMessage());
        return RestResponse.error(e.getMessage());
    }

    //特定异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody //为了返回数据
    public RestResponse error(ArithmeticException e) {
        log.error(e.getMessage());
        return RestResponse.error(e.getMessage());
    }

    //自定义异常
    @ExceptionHandler(MyException.class)
    @ResponseBody //为了返回数据
    public RestResponse error(MyException e) {
        log.error(e.getMessage());
        return RestResponse.error(e.getMsg());
    }
}
