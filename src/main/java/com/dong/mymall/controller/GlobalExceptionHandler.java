package com.dong.mymall.controller;

import com.dong.mymall.pojo.JsonResult;
import com.dong.mymall.service.ex.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> exceptionHandler(Throwable e) {
        JsonResult<Void> result = new JsonResult<>();
        result.setMessage(e.getMessage());

        if (e instanceof ArgumentEmptyException) {
            result.setState(4001);
        } else if (e instanceof DataFormatNotMatchException) {
            result.setState(4002);
        } else if (e instanceof EmailDuplicateException) {
            result.setState(4003);
        } else if (e instanceof UsernameDuplicateException) {
            result.setState(4004);
        } else if (e instanceof InsertException) {
            result.setState(5001);
        } else {
            result.setState(0);
        }

        return result;
    }
}
