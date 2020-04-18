package com.dong.mymall.service.ex;

/**
 * 参数为空异常
 */
public class ArgumentEmptyException extends ServiceException{
    private static final long serialVersionUID = -61462403575224866L;

    public ArgumentEmptyException() {
        super();
    }

    public ArgumentEmptyException(String message) {
        super(message);
    }

    public ArgumentEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArgumentEmptyException(Throwable cause) {
        super(cause);
    }

    protected ArgumentEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
