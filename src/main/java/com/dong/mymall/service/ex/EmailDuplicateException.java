package com.dong.mymall.service.ex;

/**
 * 用户邮箱冲突异常
 */
public class EmailDuplicateException extends ServiceException {
    private static final long serialVersionUID = 6281171499112471006L;

    public EmailDuplicateException() {
        super();
    }

    public EmailDuplicateException(String message) {
        super(message);
    }

    public EmailDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailDuplicateException(Throwable cause) {
        super(cause);
    }

    protected EmailDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
