package org.llaccj.yizhong.service.others;

import org.apache.ibatis.annotations.Mapper;
import org.llaccj.yizhong.module.Collect;

import java.util.List;

@Mapper
public interface CollectMapper {
    //添加收藏
    Boolean insertSelective(Collect record);
    //根据用户id 查看所有收藏 根据时间排序
    List<Collect> getCollectsByUserid(Integer userId);
    // 查看 用户是否收藏文章
    List<Collect> getIsCollected(Integer userid, Integer titleid);
    //取消收藏
    Boolean deleteCollect(Collect collect);

    //取消收藏 不使用
    Boolean deleteByPrimaryKey(Integer id);

    int insert(Collect record);



    Collect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);



}