package com.dong.mymall.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * 用于封装要返回给用户的数据、状态和信息的类
 */
public class JsonResult<T> implements Serializable {
    private int state;
    private String message;
    private T data;
    private static final int SUCCESS_STATE = 2000;
    private static final String SUCCESS_MESSAGE= "OK";

    public static <E> JsonResult<E> getSuccessResult(E data){
        return new JsonResult<E>(SUCCESS_STATE,SUCCESS_MESSAGE,data);
    }

    public static JsonResult<Void> getSuccessResult(){
        return new JsonResult<Void>(SUCCESS_STATE,SUCCESS_MESSAGE,null);
    }

    public JsonResult() {
    }

    public JsonResult(int state, String message, T data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonResult<?> that = (JsonResult<?>) o;
        return Objects.equals(state, that.state) &&
                Objects.equals(message, that.message) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, message, data);
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "state=" + state +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
