package org.llaccj.yizhong.service.gift;

import org.apache.ibatis.annotations.Mapper;
import org.llaccj.yizhong.module.GiftLog;

import java.util.List;

@Mapper
public interface GiftLogMapper {

    //用户兑换礼物
    Boolean insertSelective(GiftLog record);
    //管理员查看兑换记录
    List<GiftLog> getgiflog();
    //用户获取自己的兑换记录
    List<GiftLog> selectUserGiftLog(Integer id);


    int deleteByPrimaryKey(Integer id);

    int insert(GiftLog record);



    GiftLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GiftLog record);

    int updateByPrimaryKey(GiftLog record);



}