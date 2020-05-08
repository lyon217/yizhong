package org.llaccj.yizhong.module;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import java.util.Date;

@ApiModel(value = "Title:文章对象")
@Component
public class Title {
    @ApiModelProperty(value = "自增id",dataType = "Integer")
    private Integer id;
    @ApiModelProperty(value = "文章名",dataType = "String")
    private String titlename;
    @ApiModelProperty(value = "作者id",dataType = "Integer")
    private Integer authorid;
    @ApiModelProperty(value = "作者名",dataType = "String")
    private String authorname;
    @ApiModelProperty(value = "图片url",dataType = "String")
    private String picurl;
    @ApiModelProperty(value = "发布时间",dataType = "date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date posttime;
    @ApiModelProperty(value = "活动开始时间",dataType = "date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date beginTime;
    @ApiModelProperty(value = "活动结束时间",dataType = "date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;
    @ApiModelProperty(value = "所属类别代码1",dataType = "Integer")
    private Integer codeone;
    @ApiModelProperty(value = "所属类别代码2",dataType = "Integer")
    private Integer codetwo;
    @ApiModelProperty(value = "点赞数",dataType = "Integer")
    private Integer likenum;
    @ApiModelProperty(value = "不值数",dataType = "Integer")
    private Integer unlikenum;
    @ApiModelProperty(value = "收藏数",dataType = "Integer")
    private Integer collectnum;
    @ApiModelProperty(value = "发布时IP地址",dataType = "String")
    private String ip;
    @ApiModelProperty(value = "文本内容",dataType = "String")
    private String content;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", titlename='" + titlename + '\'' +
                ", authorid=" + authorid +
                ", authorname='" + authorname + '\'' +
                ", picurl='" + picurl + '\'' +
                ", posttime=" + posttime +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", codeone=" + codeone +
                ", codetwo=" + codetwo +
                ", likenum=" + likenum +
                ", unlikenum=" + unlikenum +
                ", collectnum=" + collectnum +
                ", ip='" + ip + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Title(Integer id, String titlename, Integer authorid, String authorname, String picurl, Date posttime, Date beginTime, Date endTime, Integer codeone, Integer codetwo, Integer likenum, Integer unlikenum, Integer collectnum, String ip) {
        this.id = id;
        this.titlename = titlename;
        this.authorid = authorid;
        this.authorname = authorname;
        this.picurl = picurl;
        this.posttime = posttime;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.codeone = codeone;
        this.codetwo = codetwo;
        this.likenum = likenum;
        this.unlikenum = unlikenum;
        this.collectnum = collectnum;
        this.ip = ip;
    }

    public Title(Integer id, String titlename, Integer authorid, String authorname, String picurl, Date posttime, Date beginTime, Date endTime, Integer codeone, Integer codetwo, Integer likenum, Integer unlikenum, Integer collectnum, String ip, String content) {
        this.id = id;
        this.titlename = titlename;
        this.authorid = authorid;
        this.authorname = authorname;
        this.picurl = picurl;
        this.posttime = posttime;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.codeone = codeone;
        this.codetwo = codetwo;
        this.likenum = likenum;
        this.unlikenum = unlikenum;
        this.collectnum = collectnum;
        this.ip = ip;
        this.content = content;
    }

    public Title() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitlename() {
        return titlename;
    }

    public void setTitlename(String titlename) {
        this.titlename = titlename == null ? null : titlename.trim();
    }

    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname == null ? null : authorname.trim();
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl == null ? null : picurl.trim();
    }

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getCodeone() {
        return codeone;
    }

    public void setCodeone(Integer codeone) {
        this.codeone = codeone;
    }

    public Integer getCodetwo() {
        return codetwo;
    }

    public void setCodetwo(Integer codetwo) {
        this.codetwo = codetwo;
    }

    public Integer getLikenum() {
        return likenum;
    }

    public void setLikenum(Integer likenum) {
        this.likenum = likenum;
    }

    public Integer getUnlikenum() {
        return unlikenum;
    }

    public void setUnlikenum(Integer unlikenum) {
        this.unlikenum = unlikenum;
    }

    public Integer getCollectnum() {
        return collectnum;
    }

    public void setCollectnum(Integer collectnum) {
        this.collectnum = collectnum;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}