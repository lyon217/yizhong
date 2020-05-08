package org.llaccj.yizhong.module;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import java.util.Date;

@ApiModel(value = "GiftLog 礼物兑换记录")
@Component
public class GiftLog {
    @ApiModelProperty(value = "礼物兑换记录自增id", dataType = "Integer")
    private Integer id;
    @ApiModelProperty(value = "兑换礼物的用户ID", dataType = "Integer")
    private Integer userid;
    @ApiModelProperty(value = "兑换礼物的用户电话(必填)", dataType = "String")
    private String usertel;
    @ApiModelProperty(value = "兑换礼物的用户邮箱(可有可无)", dataType = "String")
    private String useremail;
    @ApiModelProperty(value = "兑换礼物的用户名", dataType = "String")
    private String username;
    @ApiModelProperty(value = "兑换礼物的礼物ID", dataType = "Integer")
    private Integer giftid;
    @ApiModelProperty(value = "兑换礼物的礼物名", dataType = "String")
    private String giftname;
    @ApiModelProperty(value = "兑换时间(系统自动更新)", dataType = "Date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date time;
    @ApiModelProperty(value = "兑换地址", dataType = "String")
    private String address;


    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", userid=" + userid +
                ", usertel='" + usertel + '\'' +
                ", useremail='" + useremail + '\'' +
                ", username='" + username + '\'' +
                ", giftid=" + giftid +
                ", giftname='" + giftname + '\'' +
                ", time=" + time +
                ", address='" + address + '\'' +
                '}';
    }



    public GiftLog(Integer id, Integer userid, String usertel, String useremail, String username, Integer giftid, String giftname, Date time, String address) {
        this.id = id;
        this.userid = userid;
        this.usertel = usertel;
        this.useremail = useremail;
        this.username = username;
        this.giftid = giftid;
        this.giftname = giftname;
        this.time = time;
        this.address = address;
    }

    public GiftLog() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsertel() {
        return usertel;
    }

    public void setUsertel(String usertel) {
        this.usertel = usertel == null ? null : usertel.trim();
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getGiftid() {
        return giftid;
    }

    public void setGiftid(Integer giftid) {
        this.giftid = giftid;
    }

    public String getGiftname() {
        return giftname;
    }

    public void setGiftname(String giftname) {
        this.giftname = giftname == null ? null : giftname.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}