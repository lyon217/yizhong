package org.llaccj.yizhong.service.others;

import org.apache.ibatis.annotations.Mapper;
import org.llaccj.yizhong.module.Weekbest;

@Mapper
public interface WeekbestMapper {

   Weekbest GetTitleClickupRanking(Integer weeknum);

    int deleteByPrimaryKey(Integer id);

    int insert(Weekbest record);

    int insertSelective(Weekbest record);

    Weekbest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Weekbest record);

    int updateByPrimaryKey(Weekbest record);

 Weekbest getUserWeekBest(Integer weeknum);
}