package org.llaccj.yizhong.module.config;

import org.springframework.stereotype.Component;

/**
 * @ClassName ErrorInfo
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-16 12:02
 * @Version
 **/

@Component
public class ErrorInfo<T> {
    private Integer status;
    private String message;
    private String url;
    private T data;


    public ErrorInfo()
    {

    }
    public ErrorInfo(Integer status, String message, String url, T data) {
        this.status = status;
        this.message = message;
        this.url = url;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ErrorInfo{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", url='" + url + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
