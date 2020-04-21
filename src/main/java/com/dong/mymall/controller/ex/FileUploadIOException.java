package com.dong.mymall.controller.ex;

/**
 * 文件上传时出现的IO异常
 */
public class FileUploadIOException extends FileUploadException {
    private static final long serialVersionUID = 6562139808304995216L;

    public FileUploadIOException() {
        super();
    }

    public FileUploadIOException(String message) {
        super(message);
    }

    public FileUploadIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadIOException(Throwable cause) {
        super(cause);
    }

    protected FileUploadIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
