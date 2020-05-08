package org.llaccj.yizhong.module;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@ApiModel
public class Subscribe {
    @ApiModelProperty(value = "自增id",dataType = "Integer")
    private Integer id;
    @ApiModelProperty(value = "被关注的用户id",dataType = "Integer")
    private Integer subscribeId;
    @ApiModelProperty(value = "关注用户id",dataType = "Integer")
    private Integer subscribeUserid;
    @ApiModelProperty(value = "",dataType = "Date")
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date subscribeTime;

    public Subscribe(Integer id, Integer subscribeId, Integer subscribeUserid, Date subscribeTime) {
        this.id = id;
        this.subscribeId = subscribeId;
        this.subscribeUserid = subscribeUserid;
        this.subscribeTime = subscribeTime;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", subscribeId=" + subscribeId +
                ", subscribeUserid=" + subscribeUserid +
                ", subscribeTime=" + subscribeTime +
                '}';
    }

    public Subscribe() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(Integer subscribeId) {
        this.subscribeId = subscribeId;
    }

    public Integer getSubscribeUserid() {
        return subscribeUserid;
    }

    public void setSubscribeUserid(Integer subscribeUserid) {
        this.subscribeUserid = subscribeUserid;
    }

    public Date getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Date subscribeTime) {
        this.subscribeTime = subscribeTime;
    }
}