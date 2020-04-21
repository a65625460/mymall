package com.dong.mymall.controller.ex;

/**
 * 上传文件大小超出限制异常
 */
public class FileUploadSizeOutOfBoundException extends FileUploadException {
    private static final long serialVersionUID = -5780680235991392062L;

    public FileUploadSizeOutOfBoundException() {
        super();
    }

    public FileUploadSizeOutOfBoundException(String message) {
        super(message);
    }

    public FileUploadSizeOutOfBoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadSizeOutOfBoundException(Throwable cause) {
        super(cause);
    }

    protected FileUploadSizeOutOfBoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
