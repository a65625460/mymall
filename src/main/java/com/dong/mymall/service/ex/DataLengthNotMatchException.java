package com.dong.mymall.service.ex;

/**
 * 数据长度不匹配异常：
 *      密码长度不匹配
 *      用户名长度不匹配
 */
public class DataLengthNotMatchException extends ServiceException {
    private static final long serialVersionUID = -2408691385655517425L;

    public DataLengthNotMatchException() {
        super();
    }

    public DataLengthNotMatchException(String message) {
        super(message);
    }

    public DataLengthNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataLengthNotMatchException(Throwable cause) {
        super(cause);
    }

    protected DataLengthNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
