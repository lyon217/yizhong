package org.llaccj.yizhong.module;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AdminTable管理员对象")
public class AdminTable {
    @ApiModelProperty(value = "管理员自增id",dataType = "Integer")
    private Integer id;
    @ApiModelProperty(value = "管理员用户名",dataType = "String")
    private String aName;
    @ApiModelProperty(value = "管理员密码",dataType = "String")
    private String aPassword;
    @ApiModelProperty(value = "管理员状态",dataType = "String")
    private String aStatus;
    @ApiModelProperty(value = "管理员头像",dataType = "String")
    private String aHeadurl;

    public AdminTable(Integer id, String aName, String aPassword, String aStatus, String aHeadurl) {
        this.id = id;
        this.aName = aName;
        this.aPassword = aPassword;
        this.aStatus = aStatus;
        this.aHeadurl = aHeadurl;
    }

    public String getaHeadurl() {
        return aHeadurl;
    }

    public void setaHeadurl(String aHeadurl) {
        this.aHeadurl = aHeadurl;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", aName='" + aName + '\'' +
                ", aPassword='" + aPassword + '\'' +
                ", aStatus='" + aStatus + '\'' +
                ", aHeadurl='" + aHeadurl + '\'' +
                '}';
    }

    public AdminTable() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName == null ? null : aName.trim();
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword == null ? null : aPassword.trim();
    }

    public String getaStatus() {
        return aStatus;
    }

    public void setaStatus(String aStatus) {
        this.aStatus = aStatus;
    }
}