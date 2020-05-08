package org.llaccj.yizhong.service.others;

import org.llaccj.yizhong.module.config.ResultInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName JubaoServiceImpl
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-21 20:06
 * @Version
 **/
@Service
public class JubaoServiceImpl implements JubaoService {

    @Resource
    JubaoMapper jubaoMapper;

    @Override
    public ResultInfo<Boolean> jubaoUserByid(Integer fromUserid, Integer toUserid) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();
        Boolean b = jubaoMapper.insertByuserid(fromUserid,toUserid);
        resultInfo.setSuccess(true);
        resultInfo.setData(b);
        return resultInfo;
    }
}
