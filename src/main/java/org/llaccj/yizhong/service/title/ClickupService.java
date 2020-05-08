package org.llaccj.yizhong.service.title;

import org.llaccj.yizhong.module.Clickup;
import org.llaccj.yizhong.module.config.ResultInfo;

/**
 * @ClassName ClickupService
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-19 14:48
 * @Version
 **/
public interface ClickupService{
    //给评论点赞
    ResultInfo<Boolean> commonLike(Clickup clickup);


    //给文章点赞
    ResultInfo<Boolean> titleLike(Clickup clickup);
    //给文章点踩
    ResultInfo<Boolean> titleunLike(Clickup clickup);


    //给回复评论点赞
    ResultInfo<Boolean> commonReplyLike(Clickup clickup);

    //判断  user是否已经对id 点过赞
    ResultInfo<Boolean> isClickUp(Integer id,Integer userid,Integer type);

    void getTitleWeekBest();

}
