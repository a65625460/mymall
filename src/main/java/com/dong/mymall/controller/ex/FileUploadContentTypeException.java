package com.dong.mymall.controller.ex;

/**
 * 上传文件类型异常
 */
public class FileUploadContentTypeException extends FileUploadException {
    private static final long serialVersionUID = 1921285055858062176L;

    public FileUploadContentTypeException() {
        super();
    }

    public FileUploadContentTypeException(String message) {
        super(message);
    }

    public FileUploadContentTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadContentTypeException(Throwable cause) {
        super(cause);
    }

    protected FileUploadContentTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
