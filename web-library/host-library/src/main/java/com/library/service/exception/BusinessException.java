package com.library.service.exception;

public class BusinessException extends RuntimeException{
    private boolean success;
    private Object data;
    private String code;
    private Throwable cause;

    @Override
    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    public BusinessException(boolean success, Object data, String code, Throwable cause) {
        this.success = success;
        this.data = data;
        this.code = code;
        this.cause = cause;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
