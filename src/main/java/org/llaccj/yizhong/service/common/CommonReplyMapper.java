package org.llaccj.yizhong.service.common;

import org.apache.ibatis.annotations.Mapper;
import org.llaccj.yizhong.module.CommonReply;

import java.util.List;

@Mapper
public interface CommonReplyMapper {
    //回复评论
    Boolean insertSelective(CommonReply record);

    //查看某一评论所有的回复评论  (按照时间排序)
    List<CommonReply> getCommonReyly(Integer replycommonid);

    List<CommonReply> selectByPrimaryKey(Integer id);

    //给某一个回复评论点赞
    Boolean addlikenum(Integer id);
    //因为删除评论而删除评论的回复
    Boolean deleteCommon(Integer id);
    //因为删除文章而删除该文章下所有的评论的回复评论
//    void deleteBydeletTitle(Integer titleId);



    int deleteByPrimaryKey(Integer id);

    int insert(CommonReply record);


    int updateByPrimaryKeySelective(CommonReply record);

    int updateByPrimaryKey(CommonReply record);


}