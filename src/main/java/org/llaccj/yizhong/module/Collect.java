package org.llaccj.yizhong.module;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import java.util.Date;

@ApiModel("Collect:收藏表")
@Component
public class Collect {
    @ApiModelProperty(value = "自增id",dataType = "Integer")
    private Integer id;
    @ApiModelProperty(value = "收藏文章id",dataType = "Integer")
    private Integer collectId;
    @ApiModelProperty(value = "收藏用户id",dataType = "Integer")
    private Integer collectUserid;
    @ApiModelProperty(value = "收藏时间",dataType = "Date")
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date collectTime;

    public Collect(Integer id, Integer collectId, Integer collectUserid, Date collectTime) {
        this.id = id;
        this.collectId = collectId;
        this.collectUserid = collectUserid;
        this.collectTime = collectTime;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", collectId=" + collectId +
                ", collectUserid=" + collectUserid +
                ", collectTime=" + collectTime +
                '}';
    }

    public Collect() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public Integer getCollectUserid() {
        return collectUserid;
    }

    public void setCollectUserid(Integer collectUserid) {
        this.collectUserid = collectUserid;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }
}