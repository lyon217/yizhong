package org.llaccj.yizhong.module;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import java.util.Date;

@ApiModel(value = "CommonReply 评论回复表")
@Component
public class CommonReply {
    @ApiModelProperty(value = "评论回复表自增id", dataType = "Integer")
    private Integer id;
    @ApiModelProperty(value = "回复的评论id", dataType = "Integer")
    private Integer replycommonid;
    @ApiModelProperty(value = "回复内容", dataType = "String")
    private String replycontent;
    @ApiModelProperty(value = "回复来自的用户id", dataType = "Integer")
    private Integer replyFromUserid;
    @ApiModelProperty(value = "回复来自的用户名", dataType = "String")
    private String replyFromUsername;
    @ApiModelProperty(value = "所回复的用户id", dataType = "Integer")
    private Integer replyToUserid;
    @ApiModelProperty(value = "回复的用户名", dataType = "String")
    private String replyToUsername;
    @ApiModelProperty(value = "评论回复时间(系统自动更新)", dataType = "date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date replyTime;
    @ApiModelProperty(value = "所回复的点赞数", dataType = "Integer")
    private Integer replyLikeNum;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", replycommonid=" + replycommonid +
                ", replycontent='" + replycontent + '\'' +
                ", replyFromUserid=" + replyFromUserid +
                ", replyFromUsername='" + replyFromUsername + '\'' +
                ", replyToUserid=" + replyToUserid +
                ", replyToUsername='" + replyToUsername + '\'' +
                ", replyTime=" + replyTime +
                ", replyLikeNum=" + replyLikeNum +
                '}';
    }

    public CommonReply(){

    }
    public CommonReply(Integer id, Integer replycommonid, String replycontent, Integer replyFromUserid, String replyFromUsername, Integer replyToUserid, String replyToUsername, Date replyTime, Integer replyLikeNum) {
        this.id = id;
        this.replycommonid = replycommonid;
        this.replycontent = replycontent;
        this.replyFromUserid = replyFromUserid;
        this.replyFromUsername = replyFromUsername;
        this.replyToUserid = replyToUserid;
        this.replyToUsername = replyToUsername;
        this.replyTime = replyTime;
        this.replyLikeNum = replyLikeNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReplycommonid() {
        return replycommonid;
    }

    public void setReplycommonid(Integer replycommonid) {
        this.replycommonid = replycommonid;
    }

    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent;
    }

    public Integer getReplyFromUserid() {
        return replyFromUserid;
    }

    public void setReplyFromUserid(Integer replyFromUserid) {
        this.replyFromUserid = replyFromUserid;
    }

    public String getReplyFromUsername() {
        return replyFromUsername;
    }

    public void setReplyFromUsername(String replyFromUsername) {
        this.replyFromUsername = replyFromUsername;
    }

    public Integer getReplyToUserid() {
        return replyToUserid;
    }

    public void setReplyToUserid(Integer replyToUserid) {
        this.replyToUserid = replyToUserid;
    }

    public String getReplyToUsername() {
        return replyToUsername;
    }

    public void setReplyToUsername(String replyToUsername) {
        this.replyToUsername = replyToUsername;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public Integer getReplyLikeNum() {
        return replyLikeNum;
    }

    public void setReplyLikeNum(Integer replyLikeNum) {
        this.replyLikeNum = replyLikeNum;
    }
}