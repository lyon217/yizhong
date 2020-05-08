package org.llaccj.yizhong.module;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@ApiModel(value = "MainPic:轮播图对象")
public class MainPic {

    @ApiModelProperty(value = "自增id", dataType = "Integer")
    private Integer id;
    @ApiModelProperty(value = "主题URL", dataType = "String")
    private String picurl;
    @ApiModelProperty(value = "文章标题", dataType = "Integer")
    private Integer titleid;
    @ApiModelProperty(value = "文章名", dataType = "String")
    private String titlename;
    @ApiModelProperty(value = "描述", dataType = "String")
    private String description;
    @ApiModelProperty(value = "管理员id", dataType = "Integer")
    private Integer adminid;
    @ApiModelProperty(value = "发布时间", dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;


    public MainPic(Integer id, String picurl, Integer titleid, String titlename, String description, Integer adminid, Date time) {
        this.id = id;
        this.picurl = picurl;
        this.titleid = titleid;
        this.titlename = titlename;
        this.description = description;
        this.adminid = adminid;
        this.time = time;
    }

    public MainPic() {

    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", picurl='" + picurl + '\'' +
                ", titleid=" + titleid +
                ", titlename='" + titlename + '\'' +
                ", description='" + description + '\'' +
                ", adminid=" + adminid +
                ", time=" + time +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public Integer getTitleid() {
        return titleid;
    }

    public void setTitleid(Integer titleid) {
        this.titleid = titleid;
    }

    public String getTitlename() {
        return titlename;
    }

    public void setTitlename(String titlename) {
        this.titlename = titlename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public Date gettime() {
        return time;
    }

    public void settime(Date time) {
        this.time = time;
    }
}