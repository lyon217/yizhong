package org.llaccj.yizhong.service.title;

import org.apache.ibatis.annotations.Mapper;
import org.llaccj.yizhong.module.Clickup;
import org.llaccj.yizhong.module.Rankings;

import java.util.List;

@Mapper
public interface ClickupMapper {

    Boolean insertSelective(Clickup record);

    //判断  用户userid  是否对 类型为type的 id点过赞
    List<Clickup> isClickUp(Integer id, Integer userid, Integer type);

    int deleteByPrimaryKey(Integer id);

    int insert(Clickup record);

    Clickup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Clickup record);

    int updateByPrimaryKey(Clickup record);

    //-----------------------------------------------定时任务进行统计

    List<Rankings> CountTitleClickupWeekly();



}