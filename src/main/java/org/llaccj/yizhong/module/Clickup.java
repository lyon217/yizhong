package org.llaccj.yizhong.module;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@ApiModel(value = "Clickup 点赞对象")
public class Clickup {
    @ApiModelProperty(value = "点赞对象自增id",dataType = "Integer")
    private Integer id;
    @ApiModelProperty(value = "点赞的文章id 或者是评论id",dataType = "Integer")
    private Integer clickupId;
    @ApiModelProperty(value = "点赞的用户id",dataType = "Integer")
    private Integer clickupToUserid;
    @ApiModelProperty(value = "点赞的用户名",dataType = "String")
    private String clickupToUsername;
    @ApiModelProperty(value = "点赞的来自用户id",dataType = "Integer")
    private Integer clickupFromUserid;
    @ApiModelProperty(value = "点赞的来自用户名",dataType = "String")
    private String clickupFromUsername;
    @ApiModelProperty(value = "点赞时间 (系统自动更新)",dataType = "date")
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date clickupTime;
    @ApiModelProperty(value = "点赞类型 0文章点赞 1评论点赞 2评论回复点赞",dataType = "Integer")
    private Integer clickupType;

    public Clickup(Integer id, Integer clickupId, Integer clickupToUserid, String clickupToUsername, Integer clickupFromUserid, String clickupFromUsername, Date clickupTime, Integer clickupType) {
        this.id = id;
        this.clickupId = clickupId;
        this.clickupToUserid = clickupToUserid;
        this.clickupToUsername = clickupToUsername;
        this.clickupFromUserid = clickupFromUserid;
        this.clickupFromUsername = clickupFromUsername;
        this.clickupTime = clickupTime;
        this.clickupType = clickupType;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", clickupId=" + clickupId +
                ", clickupToUserid=" + clickupToUserid +
                ", clickupToUsername='" + clickupToUsername + '\'' +
                ", clickupFromUserid=" + clickupFromUserid +
                ", clickupFromUsername='" + clickupFromUsername + '\'' +
                ", clickupTime=" + clickupTime +
                ", clickupType=" + clickupType +
                '}';
    }

    public Clickup() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClickupId() {
        return clickupId;
    }

    public void setClickupId(Integer clickupId) {
        this.clickupId = clickupId;
    }

    public Integer getClickupToUserid() {
        return clickupToUserid;
    }

    public void setClickupToUserid(Integer clickupToUserid) {
        this.clickupToUserid = clickupToUserid;
    }

    public String getClickupToUsername() {
        return clickupToUsername;
    }

    public void setClickupToUsername(String clickupToUsername) {
        this.clickupToUsername = clickupToUsername == null ? null : clickupToUsername.trim();
    }

    public Integer getClickupFromUserid() {
        return clickupFromUserid;
    }

    public void setClickupFromUserid(Integer clickupFromUserid) {
        this.clickupFromUserid = clickupFromUserid;
    }

    public String getClickupFromUsername() {
        return clickupFromUsername;
    }

    public void setClickupFromUsername(String clickupFromUsername) {
        this.clickupFromUsername = clickupFromUsername == null ? null : clickupFromUsername.trim();
    }

    public Date getClickupTime() {
        return clickupTime;
    }

    public void setClickupTime(Date clickupTime) {
        this.clickupTime = clickupTime;
    }

    public Integer getClickupType() {
        return clickupType;
    }

    public void setClickupType(Integer clickupType) {
        this.clickupType = clickupType;
    }
}