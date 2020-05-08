package org.llaccj.yizhong.service.common;

import org.llaccj.yizhong.module.CommonReply;
import org.llaccj.yizhong.module.CommonWithUserValue;
import org.llaccj.yizhong.module.Commons;
import org.llaccj.yizhong.module.config.ResultInfo;
import org.llaccj.yizhong.service.user.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CommonServiceImpl
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-19 14:27
 * @Version
 **/
@Service
public class CommonServiceImpl implements CommonService {

    @Resource
    CommonsMapper commonsMapper;
    @Resource
    CommonReplyMapper commonReplyMapper;
    @Resource
    UserMapper userMapper;

    @Override
    public ResultInfo<Boolean> userCommon(Commons commons) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();

        Boolean i = commonsMapper.insertSelective(commons);
        if (i) {
            resultInfo.setSuccess(true);
            resultInfo.setMessage("评论成功");
        } else {
            resultInfo.setSuccess(false);
            resultInfo.setMessage("评论失败");
        }
        return resultInfo;
    }

    @Override
    public ResultInfo<Boolean> commonReply(CommonReply commonReply) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();

        Boolean i = commonReplyMapper.insertSelective(commonReply);
        if (i) {
            resultInfo.setSuccess(true);
            resultInfo.setMessage("回复评论成功");
        } else {
            resultInfo.setSuccess(false);
            resultInfo.setMessage("回复评论失败");
        }
        return resultInfo;
    }

    @Override
    public ResultInfo<List<CommonWithUserValue>> getcommons(int cOfTitleid) {
        ResultInfo<List<CommonWithUserValue>> resultInfo = new ResultInfo<>();
        List<CommonWithUserValue> a = new ArrayList<>();

        List<Commons> commons = commonsMapper.getcommons(cOfTitleid);
        for (int i = 0; i <commons.size() ; i++) {
            String userheadurl = userMapper.selectUserHeadurl(commons.get(i).getcFromUserid());
            a.add(new CommonWithUserValue(commons.get(i),userheadurl));
        }

        if (!commons.isEmpty()) {
            resultInfo.setSuccess(true);
            resultInfo.setMessage("共获取评论" + a.size() + "条");
            resultInfo.setData(a);
        } else {
            resultInfo.setSuccess(false);
            resultInfo.setMessage("共获取评论0条");
        }
        return resultInfo;
    }

    @Override
    public ResultInfo<Boolean> deleteCommon(Integer id) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();
        Boolean b = commonsMapper.deleteByPrimaryKey(id);
        if (b){
            resultInfo.setMessage("删除成功");
        }else {
            resultInfo.setMessage("评论不存");
        }
        resultInfo.setSuccess(b);

        //删除该评论的回复评论
        commonReplyMapper.deleteCommon(id);

        return resultInfo;
    }

    @Override
    public ResultInfo<List<Commons>> getPersonalCommons(Integer id) {
        ResultInfo<List<Commons>> resultInfo = new ResultInfo<>();

        List<Commons> commons = commonsMapper.selectPersonalCommons(id);

        resultInfo.setSuccess(true);
        resultInfo.setData(commons);
        resultInfo.setMessage("共计"+commons.size()+"条");

        return resultInfo;
    }


}
