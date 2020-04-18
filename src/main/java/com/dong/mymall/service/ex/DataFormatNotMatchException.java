package com.dong.mymall.service.ex;

/**
 * 邮箱格式不匹配异常
 */
public class DataFormatNotMatchException extends ServiceException {
    private static final long serialVersionUID = -1068671347652909909L;

    public DataFormatNotMatchException() {
        super();
    }

    public DataFormatNotMatchException(String message) {
        super(message);
    }

    public DataFormatNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataFormatNotMatchException(Throwable cause) {
        super(cause);
    }

    protected DataFormatNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
