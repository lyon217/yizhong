package org.llaccj.yizhong.module.config;

import org.springframework.stereotype.Component;

/**
 * @ClassName RestInfo
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-16 12:03
 * @Version
 **/
@Component
public class ResultInfo<T> {
    private boolean success;
    private Integer code;
    private String message;
    private T data;

    public ResultInfo()
    {

    }
    public ResultInfo(boolean success, Integer code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "RestInfo{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
