package org.llaccj.yizhong.service.others;

import org.apache.ibatis.annotations.Mapper;
import org.llaccj.yizhong.module.MainPic;

import java.util.List;

@Mapper
public interface MainPicMapper {
    //增加轮播图
    Boolean insertSelective(MainPic record);
    //删除
    Boolean deleteByPrimaryKey(Integer id);
    //查看
    List<MainPic> getAll();

    int insert(MainPic record);



    MainPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MainPic record);

    int updateByPrimaryKey(MainPic record);


}