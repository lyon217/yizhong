package org.llaccj.yizhong.service.common;

import org.apache.ibatis.annotations.Mapper;
import org.llaccj.yizhong.module.Commons;

import java.util.List;

@Mapper
public interface CommonsMapper {

    Boolean insertSelective(Commons record);

    List<Commons> getcommons(Integer cOfTitleid);

    List<Commons> selectByPrimaryKey(Integer cId);

    Boolean addlikenum(Integer cId);

    Boolean deleteByPrimaryKey(Integer cId);
    //因为删除文章而删除文章的评论
    Boolean deleteCommonBydeleteTitle(Integer titleId);
    //用户查看自己对其他文章的所有评论
    List<Commons> selectPersonalCommons(Integer id);




    int insert(Commons record);


    int updateByPrimaryKeySelective(Commons record);

    int updateByPrimaryKey(Commons record);


}