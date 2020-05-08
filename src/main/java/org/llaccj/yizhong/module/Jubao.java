package org.llaccj.yizhong.module;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@ApiModel("Jubao:举报对象")
public class Jubao {
    @ApiModelProperty(value = "自增id",dataType = "Integer")
    private Integer id;
    @ApiModelProperty(value = "点击举报的用户",dataType = "Integer")
    private Integer fromUserid;
    @ApiModelProperty(value = "被举报的用户",dataType = "Integer")
    private Integer toUserid;
    @ApiModelProperty(value = "该条举报是否处理",dataType = "Integer")
    private Integer ishandle;
    @ApiModelProperty(value = "用户被举报的时间",dataType = "date")
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date time;
    @ApiModelProperty(value = "管理员处理该举报信息的时间",dataType = "date")
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date handletime;

    public Jubao(Integer id, Integer fromUserid, Integer toUserid, Integer ishandle, Date time, Date handletime) {
        this.id = id;
        this.fromUserid = fromUserid;
        this.toUserid = toUserid;
        this.ishandle = ishandle;
        this.time = time;
        this.handletime = handletime;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", fromUserid=" + fromUserid +
                ", toUserid=" + toUserid +
                ", ishandle=" + ishandle +
                ", time=" + time +
                ", handletime=" + handletime +
                '}';
    }

    public Jubao() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromUserid() {
        return fromUserid;
    }

    public void setFromUserid(Integer fromUserid) {
        this.fromUserid = fromUserid;
    }

    public Integer getToUserid() {
        return toUserid;
    }

    public void setToUserid(Integer toUserid) {
        this.toUserid = toUserid;
    }

    public Integer getIshandle() {
        return ishandle;
    }

    public void setIshandle(Integer ishandle) {
        this.ishandle = ishandle;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getHandletime() {
        return handletime;
    }

    public void setHandletime(Date handletime) {
        this.handletime = handletime;
    }
}