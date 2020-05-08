package org.llaccj.yizhong.service.others;

import org.llaccj.yizhong.module.config.ResultInfo;

/**
 * @ClassName JubaoService
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-21 20:06
 * @Version
 **/
public interface JubaoService{

    ResultInfo<Boolean> jubaoUserByid(Integer fromUserid,Integer toUserid);


}
