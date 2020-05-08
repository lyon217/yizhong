package org.llaccj.yizhong.service.others;

import org.llaccj.yizhong.module.Collect;
import org.llaccj.yizhong.module.TitleWithUserValue;
import org.llaccj.yizhong.module.config.ResultInfo;

import java.util.List;

/**
 * @ClassName CollectService
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-22 20:35
 * @Version
 **/
public interface CollectService {
    ResultInfo<Boolean> addCollect(Collect collect);

    ResultInfo<Boolean> deleteCollect(Collect id);

    ResultInfo<List<TitleWithUserValue>> getCollectsByUserid(Integer userId);

    ResultInfo<Boolean> isCollected(Integer userId, Integer titleId);

}
