package com.mall.tiny.common;

/**
 * 通用返回对象
 */
public class JSONResult<T> {

    private long code;
    private String message;
    private T data;

    protected JSONResult() {

    }

    protected JSONResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> JSONResult<T> success(T data) {
        return new JSONResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param message 提示信息
     */
    public static <T> JSONResult<T> success(T data, String message) {
        return new JSONResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     * @param errorCode 相应错误码
     */
    public static <T> JSONResult<T> failed(IErrorCode errorCode) {
        return new JSONResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> JSONResult<T> failed(String message) {
        return new JSONResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> JSONResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> JSONResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> JSONResult<T> validateFailed(String message) {
        return new JSONResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> JSONResult<T> unauthorized(T data) {
        return  new JSONResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), null);
    }

    /**
     * 未经授权返回结果
     */
    public static <T> JSONResult<T> forbidden(T data) {
        return new JSONResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
}
