package org.llaccj.yizhong.module;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@ApiModel(value = "User 用户对象")
public class User {
    @ApiModelProperty(value = "用户自增I的",dataType = "Integer")
    private Integer uId;
    @ApiModelProperty(value = "用户名(默认没有)",dataType = "String")
    private String uName;
    @ApiModelProperty(value = "用户密码",dataType = "String")
    private String uPassword;
    @ApiModelProperty(value = "用户性别  0男 1女  其他数字代表未知或不设置",dataType = "String")
    private String uSex;
    @ApiModelProperty(value = "用户电话 (登录凭据至一)",dataType = "String")
    private String uTel;
    @ApiModelProperty(value = "用户 头像URL",dataType = "String")
    private String uHeadurl;
    @ApiModelProperty(value = "用户 Email",dataType = "String")
    private String uEmail;
    @ApiModelProperty(value = "用户 地址 (兑换礼物时isNull)",dataType = "String")
    private String uAddress;
    @ApiModelProperty(value = "用户 个人简介",dataType = "String")
    private String uProfile;
    @ApiModelProperty(value = "用户  文章数",dataType = "Integer")
    private Integer uTitlenum;
    @ApiModelProperty(value = "用户 经验值",dataType = "Integer")
    private Integer uEx;
    @ApiModelProperty(value = "用户 金币数",dataType = "Integer")
    private Integer uGoldnum;
    @ApiModelProperty(value = "用户 创建时间 (mysql自动更新)",dataType = "date")
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date uCreateTime;
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "用户 数据更新时间(mysql自动更新)",dataType = "date")
    private Date uUpdateTime;
    @ApiModelProperty(value = "账户是否可用",dataType = "Integer")
    private Integer uIsenable;

    public User() {
    }

    @Override
    public String toString() {
        return "{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uSex='" + uSex + '\'' +
                ", uTel='" + uTel + '\'' +
                ", uHeadurl='" + uHeadurl + '\'' +
                ", uEmail='" + uEmail + '\'' +
                ", uAddress='" + uAddress + '\'' +
                ", uProfile='" + uProfile + '\'' +
                ", uTitlenum=" + uTitlenum +
                ", uEx=" + uEx +
                ", uGoldnum=" + uGoldnum +
                ", uCreateTime=" + uCreateTime +
                ", uUpdateTime=" + uUpdateTime +
                ", uEnable=" + uIsenable +
                '}';
    }

    public User(Integer uId, String uName, String uPassword, String uSex, String uTel, String uHeadurl, String uEmail, String uAddress, String uProfile, Integer uTitlenum, Integer uEx, Integer uGoldnum, Date uCreateTime, Date uUpdateTime, Integer uEnable) {
        this.uId = uId;
        this.uName = uName;
        this.uPassword = uPassword;
        this.uSex = uSex;
        this.uTel = uTel;
        this.uHeadurl = uHeadurl;
        this.uEmail = uEmail;
        this.uAddress = uAddress;
        this.uProfile = uProfile;
        this.uTitlenum = uTitlenum;
        this.uEx = uEx;
        this.uGoldnum = uGoldnum;
        this.uCreateTime = uCreateTime;
        this.uUpdateTime = uUpdateTime;
        this.uIsenable = uEnable;
    }
    public User(Integer uId, String uName, String uSex, String uTel, String uHeadurl, String uEmail, String uAddress, String uProfile, Integer uTitlenum, Integer uEx, Integer uGoldnum, Date uCreateTime, Date uUpdateTime, Integer uEnable) {
        this.uId = uId;
        this.uName = uName;
        this.uSex = uSex;
        this.uTel = uTel;
        this.uHeadurl = uHeadurl;
        this.uEmail = uEmail;
        this.uAddress = uAddress;
        this.uProfile = uProfile;
        this.uTitlenum = uTitlenum;
        this.uEx = uEx;
        this.uGoldnum = uGoldnum;
        this.uCreateTime = uCreateTime;
        this.uUpdateTime = uUpdateTime;
        this.uIsenable = uEnable;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    public String getuTel() {
        return uTel;
    }

    public void setuTel(String uTel) {
        this.uTel = uTel;
    }

    public String getuHeadurl() {
        return uHeadurl;
    }

    public void setuHeadurl(String uHeadurl) {
        this.uHeadurl = uHeadurl;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public String getuProfile() {
        return uProfile;
    }

    public void setuProfile(String uProfile) {
        this.uProfile = uProfile;
    }

    public Integer getuTitlenum() {
        return uTitlenum;
    }

    public void setuTitlenum(Integer uTitlenum) {
        this.uTitlenum = uTitlenum;
    }

    public Integer getuEx() {
        return uEx;
    }

    public void setuEx(Integer uEx) {
        this.uEx = uEx;
    }

    public Integer getuGoldnum() {
        return uGoldnum;
    }

    public void setuGoldnum(Integer uGoldnum) {
        this.uGoldnum = uGoldnum;
    }

    public Date getuCreateTime() {
        return uCreateTime;
    }

    public void setuCreateTime(Date uCreateTime) {
        this.uCreateTime = uCreateTime;
    }

    public Date getuUpdateTime() {
        return uUpdateTime;
    }

    public void setuUpdateTime(Date uUpdateTime) {
        this.uUpdateTime = uUpdateTime;
    }

    public Integer getuEnable() {
        return uIsenable;
    }

    public void setuEnable(Integer uEnable) {
        this.uIsenable = uEnable;
    }
}