package org.llaccj.yizhong.service.others;

import org.llaccj.yizhong.module.Subscribe;
import org.llaccj.yizhong.module.User;
import org.llaccj.yizhong.module.config.ResultInfo;

import java.util.List;

/**
 * @ClassName SubscribeService
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-22 20:36
 * @Version
 **/
public interface SubscribeService {
    ResultInfo<Boolean> addSubscribe(Subscribe subscribe);

    ResultInfo<Boolean> deleteSubscribe(Subscribe subscribe);

    ResultInfo<List<User>> getSubscribes(Integer id);

    ResultInfo<List<User>> getFensi(Integer id);

    ResultInfo<Boolean> getIsSubscribe(Integer ida, Integer idb);

    ResultInfo<Integer> getSubscribeNum(Integer id);

    ResultInfo<Integer> getFensiNum(Integer id);
}
