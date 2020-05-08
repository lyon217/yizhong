package org.llaccj.yizhong.service.others;

import org.apache.ibatis.annotations.Mapper;
import org.llaccj.yizhong.module.BaseDict;

import java.util.List;

@Mapper
public interface BaseDictMapper {

    //根据一级标题获取其下所有二级标题
    List<BaseDict> getCodeTwoFromOne(Integer dictCodeOne);

    List<BaseDict> selectAll();



    int deleteByPrimaryKey(Integer dictId);

    int insert(BaseDict record);

    int insertSelective(BaseDict record);

    BaseDict selectByPrimaryKey(Integer dictId);

    int updateByPrimaryKeySelective(BaseDict record);

    int updateByPrimaryKey(BaseDict record);




}