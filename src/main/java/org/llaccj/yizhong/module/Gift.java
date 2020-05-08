package org.llaccj.yizhong.module;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

@ApiModel("Gift 礼物")
@Component
public class Gift {
    @ApiModelProperty(value = "礼品自增ID",dataType = "Integer")
    private Integer id;
    @ApiModelProperty(value = "礼品图片URL",dataType = "String")
    private String url;
    @ApiModelProperty(value = "礼品名称",dataType = "String")
    private String name;
    @ApiModelProperty(value = "礼品价值",dataType = "String")
    private String value;
    @ApiModelProperty(value = "礼品兑换所需金币数",dataType = "Integer")
    private Integer goldnum;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", goldnum=" + goldnum +
                '}';
    }

    public Gift(Integer id, String url, String name, String value, Integer goldnum) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.value = value;
        this.goldnum = goldnum;
    }

    public Gift() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getGoldnum() {
        return goldnum;
    }

    public void setGoldnum(Integer goldnum) {
        this.goldnum = goldnum;
    }
}