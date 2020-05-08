package org.llaccj.yizhong.module;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import java.util.Date;

@ApiModel(value = "Commons 用户评论表")
@Component
public class Commons {
    @ApiModelProperty(value = "评论表自增id",dataType = "Integer")
    private Integer cId;
    @ApiModelProperty(value = "评论的文章id",dataType = "Integer")
    private Integer cOfTitleid;
    @ApiModelProperty(value = "评论的文章标题",dataType = "String")
    private String cOfTitlename;
    @ApiModelProperty(value = "评论的用户id",dataType = "Integer")
    private Integer cFromUserid;
    @ApiModelProperty(value = "评论的用户名",dataType = "String")
    private String cFromUsername;
    @ApiModelProperty(value = "评论内容",dataType = "String")
    private String cContent;
    @ApiModelProperty(value = "评论点赞数",dataType = "Integer")
    private Integer cLikenum;
    @ApiModelProperty(value = "评论时间",dataType = "date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date cTime;



    public Commons(Integer cId, Integer cOfTitleid, String cOfTitlename, Integer cFromUserid, String cFromUsername, String cContent, Integer cLikenum, Date cTime) {
        this.cId = cId;
        this.cOfTitleid = cOfTitleid;
        this.cOfTitlename = cOfTitlename;
        this.cFromUserid = cFromUserid;
        this.cFromUsername = cFromUsername;
        this.cContent = cContent;
        this.cLikenum = cLikenum;
        this.cTime = cTime;
    }

    @Override
    public String toString() {
        return "{" +
                "cId=" + cId +
                ", cOfTitleid=" + cOfTitleid +
                ", cOfTitlename='" + cOfTitlename + '\'' +
                ", cFromUserid=" + cFromUserid +
                ", cFromUsername='" + cFromUsername + '\'' +
                ", cContent='" + cContent + '\'' +
                ", cLikenum=" + cLikenum +
                ", cTime=" + cTime +
                '}';
    }

    public Commons() {
        super();
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getcOfTitleid() {
        return cOfTitleid;
    }

    public void setcOfTitleid(Integer cOfTitleid) {
        this.cOfTitleid = cOfTitleid;
    }

    public String getcOfTitlename() {
        return cOfTitlename;
    }

    public void setcOfTitlename(String cOfTitlename) {
        this.cOfTitlename = cOfTitlename == null ? null : cOfTitlename.trim();
    }

    public Integer getcFromUserid() {
        return cFromUserid;
    }

    public void setcFromUserid(Integer cFromUserid) {
        this.cFromUserid = cFromUserid;
    }

    public String getcFromUsername() {
        return cFromUsername;
    }

    public void setcFromUsername(String cFromUsername) {
        this.cFromUsername = cFromUsername == null ? null : cFromUsername.trim();
    }

    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent == null ? null : cContent.trim();
    }

    public Integer getcLikenum() {
        return cLikenum;
    }

    public void setcLikenum(Integer cLikenum) {
        this.cLikenum = cLikenum;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}