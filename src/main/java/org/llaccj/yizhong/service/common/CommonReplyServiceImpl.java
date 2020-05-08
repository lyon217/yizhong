package org.llaccj.yizhong.service.common;

import org.llaccj.yizhong.module.CommonReply;
import org.llaccj.yizhong.module.config.ResultInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CommonReplyServiceImpl
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-19 14:27
 * @Version
 **/
@Service
public class CommonReplyServiceImpl implements CommonReplyService{

    @Resource
    CommonReplyMapper commonReplyMapper;


    @Override
    public ResultInfo<List<CommonReply>> getCommonReply(int id) {
        ResultInfo<List<CommonReply>> resultInfo = new ResultInfo<>();

        ArrayList<CommonReply> a = new ArrayList<>();
        List<CommonReply> commonReyly = commonReplyMapper.getCommonReyly(id);
        a.addAll(commonReyly);
        if(!commonReyly.isEmpty()){
            resultInfo.setSuccess(true);
            resultInfo.setData(a);
            resultInfo.setMessage("共获取该评论的回复评论"+commonReyly.size()+"条");
        }else {
            resultInfo.setSuccess(false);
            resultInfo.setMessage("共获取该评论的回复评论0条");
        }
        return resultInfo;
    }
}
