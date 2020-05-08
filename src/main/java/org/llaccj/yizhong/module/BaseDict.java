package org.llaccj.yizhong.module;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

@ApiModel(value = "BaseDict:字典分类表")
@Component
public class BaseDict {
    @ApiModelProperty(value = "自增id",dataType = "Integer")
    private Integer dictId;
    @ApiModelProperty(value = "代码1",dataType = "Integer")
    private Integer dictCodeOne;
    @ApiModelProperty(value = "代码对应值1",dataType = "String")
    private String dictType1Name;
    @ApiModelProperty(value = "代码2",dataType = "Integer")
    private Integer dictCodeTwo;
    @ApiModelProperty(value = "代码对应值2",dataType = "String")
    private String dictType2Name;

    public BaseDict(Integer dictId, Integer dictCodeOne, String dictType1Name, Integer dictCodeTwo, String dictType2Name) {
        this.dictId = dictId;
        this.dictCodeOne = dictCodeOne;
        this.dictType1Name = dictType1Name;
        this.dictCodeTwo = dictCodeTwo;
        this.dictType2Name = dictType2Name;
    }

    @Override
    public String toString() {
        return "{" +
                "dictId=" + dictId +
                ", dictCodeOne=" + dictCodeOne +
                ", dictType1Name='" + dictType1Name + '\'' +
                ", dictCodeTwo=" + dictCodeTwo +
                ", dictType2Name='" + dictType2Name + '\'' +
                '}';
    }

    public BaseDict() {
        super();
    }

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public Integer getDictCodeOne() {
        return dictCodeOne;
    }

    public void setDictCodeOne(Integer dictCodeOne) {
        this.dictCodeOne = dictCodeOne;
    }

    public String getDictType1Name() {
        return dictType1Name;
    }

    public void setDictType1Name(String dictType1Name) {
        this.dictType1Name = dictType1Name == null ? null : dictType1Name.trim();
    }

    public Integer getDictCodeTwo() {
        return dictCodeTwo;
    }

    public void setDictCodeTwo(Integer dictCodeTwo) {
        this.dictCodeTwo = dictCodeTwo;
    }

    public String getDictType2Name() {
        return dictType2Name;
    }

    public void setDictType2Name(String dictType2Name) {
        this.dictType2Name = dictType2Name == null ? null : dictType2Name.trim();
    }
}