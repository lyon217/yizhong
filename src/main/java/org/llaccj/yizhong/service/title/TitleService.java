package org.llaccj.yizhong.service.title;

import org.llaccj.yizhong.module.Title;
import org.llaccj.yizhong.module.TitleWithUserValue;
import org.llaccj.yizhong.module.config.ResultInfo;

import java.util.List;

/**
 * @ClassName TitleService
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-20 17:29
 * @Version
 **/
public interface TitleService {
    ResultInfo<Boolean> postTitle(Title title);

    ResultInfo<TitleWithUserValue> getTitleByid(Integer titleId);

    ResultInfo<List<TitleWithUserValue>> getTitlesViauserid(Integer userId);

    ResultInfo<Boolean> deleteTitleByid(Integer titleId, Integer titleid);

    List<Title> getTitleListBydefault();

    List<Title> getTitleListByTime();

    List<Title> getTitleListByclass(Integer classone, Integer classtwo);

    ResultInfo<List<Title>> searchTitle(String titlename);

    ResultInfo<List<Title>> getTitleClickupRanking(Integer week);
}
