package org.llaccj.yizhong.service.gift;

import org.apache.ibatis.annotations.Mapper;
import org.llaccj.yizhong.module.Gift;

import java.util.List;

@Mapper
public interface GiftMapper {
    //获取所有礼物列表
    List<Gift> getGifts();

    Boolean insertSelective(Gift record);

    int deleteByPrimaryKey(Integer id);

    int insert(Gift record);
    //获取某一礼物兑换所需金币数
    int selectGiftGoldNum(Integer giftid);



    Gift selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gift record);

    int updateByPrimaryKey(Gift record);



}