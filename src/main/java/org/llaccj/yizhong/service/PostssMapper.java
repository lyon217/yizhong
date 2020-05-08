package org.llaccj.yizhong.service;

import org.apache.ibatis.annotations.Mapper;
import org.llaccj.yizhong.module.Postss;

@Mapper
public interface PostssMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Postss record);

    int insertSelective(Postss record);

    Postss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Postss record);

    int updateByPrimaryKeyWithBLOBs(Postss record);

    int updateByPrimaryKey(Postss record);
}