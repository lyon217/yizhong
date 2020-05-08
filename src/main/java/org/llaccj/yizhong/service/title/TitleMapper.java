package org.llaccj.yizhong.service.title;

import org.apache.ibatis.annotations.Mapper;
import org.llaccj.yizhong.module.Collect;
import org.llaccj.yizhong.module.Rankings;
import org.llaccj.yizhong.module.Title;

import java.util.List;

@Mapper
public interface TitleMapper {
    //发布文章
    int insertSelective(Title record);
    //通过id 获取文章
    Title selectByPrimaryKey(Integer id);
    //用户通过用户id查看所有自己的文章
    List<Title> getTitlesViauserid(Integer authorId);
    //用户删除某一帖子
    Boolean deleteByPrimaryKey(Integer id);

    //删除文章
    Boolean deleteTitle(Integer userid,Integer titleid);
    //主页获取默认列表
    List<Title> getTitleListBydefault();
    //主页获取时间排序列表
    List<Title> getTitleListByTime();
    //点赞文章 点赞数+1
    Boolean addLikeNum(Integer id);
    //点踩数+1
    Boolean addUnLikeUnm(Integer id);
    //根据类型获取titles
    List<Title> getTitleListByClass(Integer classone, Integer classtwo);
//    搜搜文章
    List<Title> searchTitle(String titlename);
    //根据收藏对象列表  获取对应的文章列表
    List<Title> getCollectTitles(List<Collect> collects);
    //收藏数更改
    Boolean addCollectNum(Integer collectId);
    Boolean reduceCollectNum(Integer collectId);

    Integer getUsreidFromTitle(Integer titleid);


    //修改类型一
//    int updateCodeOne(Integer codeone);


    int insert(Title record);

    int updateByPrimaryKeySelective(Title record);

    int updateByPrimaryKeyWithBLOBs(Title record);

    int updateByPrimaryKey(Title record);

    List<Title> getWeekBestTitle(List<Rankings> a);

}