package com.dong.mymall.controller.ex;

/**
 * 上传文件为空异常
 */
public class FileUploadEmptyException extends FileUploadException {

    private static final long serialVersionUID = 6323714896999652173L;

    public FileUploadEmptyException() {
        super();
    }

    public FileUploadEmptyException(String message) {
        super(message);
    }

    public FileUploadEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadEmptyException(Throwable cause) {
        super(cause);
    }

    protected FileUploadEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
