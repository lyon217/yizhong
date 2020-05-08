package org.llaccj.yizhong.service.common;

import org.llaccj.yizhong.module.CommonReply;
import org.llaccj.yizhong.module.config.ResultInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CommonReplyService
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-19 14:27
 * @Version
 **/
public interface CommonReplyService {
    ResultInfo<List<CommonReply>> getCommonReply(int id);
}
