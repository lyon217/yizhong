package org.llaccj.yizhong.service.common;

import org.llaccj.yizhong.module.CommonReply;
import org.llaccj.yizhong.module.CommonWithUserValue;
import org.llaccj.yizhong.module.Commons;
import org.llaccj.yizhong.module.config.ResultInfo;

import java.util.List;

/**
 * @ClassName CommonService
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-19 14:26
 * @Version
 **/
public interface CommonService {
    ResultInfo<Boolean> userCommon(Commons commons);

    ResultInfo<Boolean> commonReply(CommonReply commonReply);

    ResultInfo<List<CommonWithUserValue>> getcommons(int id);

    ResultInfo<Boolean> deleteCommon(Integer id);

    ResultInfo<List<Commons>> getPersonalCommons(Integer id);
}
