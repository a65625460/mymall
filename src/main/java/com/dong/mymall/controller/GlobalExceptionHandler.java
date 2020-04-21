package com.dong.mymall.controller;

import com.dong.mymall.controller.ex.*;
import com.dong.mymall.pojo.JsonResult;
import com.dong.mymall.service.ex.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ServiceException.class, FileUploadException.class})
    public JsonResult<Void> runtimeExceptionHandler(Throwable e) {
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
        } else if (e instanceof UserNotFoundException) {
            result.setState(4005);
        } else if (e instanceof FileUploadSizeOutOfBoundException) {
            result.setState(4006);
        } else if (e instanceof FileUploadEmptyException) {
            result.setState(4007);
        } else if (e instanceof FileUploadContentTypeException) {
            result.setState(4008);
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(4009);
        } else if (e instanceof InsertException) {
            result.setState(5001);
        } else if (e instanceof UpdateException) {
            result.setState(5002);
        } else if (e instanceof FileUploadIOException) {
            result.setState(5003);
        } else {
            result.setState(0);
        }

        return result;
    }

    @ExceptionHandler(Exception.class)
    public JsonResult<Void> exceptionHandler(Throwable e){
        JsonResult<Void> result = new JsonResult<>();
        result.setMessage("系统出现故障！请稍后再试！");
        result.setState(1);
        e.printStackTrace();
        return result;
    }
}
