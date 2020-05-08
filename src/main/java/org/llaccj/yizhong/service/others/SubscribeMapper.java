package org.llaccj.yizhong.service.others;

import org.apache.ibatis.annotations.Mapper;
import org.llaccj.yizhong.module.Subscribe;

import java.util.List;

@Mapper
public interface SubscribeMapper {
    //添加关注
    Boolean insertSelective(Subscribe record);
    //取消关注  暂时不用
    Boolean deleteByPrimaryKey(Integer id);
    //取消关注
    Boolean deleteSubscribe(Subscribe subscribe);
    //获取自己所有的关注
    List<Subscribe> getguanzhu(Integer id);
    //查看自己的粉丝
    List<Subscribe> getFensi(Integer id);
    //查看A是否关注B
    List<Subscribe> getisSubscribe(Integer ida, Integer idb);
    //获取关注总数
    Integer getSubscribenum(Integer id);
    //获取自己的粉丝数
    Integer selectFensiNum(Integer id);

    int insert(Subscribe record);



    Subscribe selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Subscribe record);

    int updateByPrimaryKey(Subscribe record);



}