package org.llaccj.yizhong.service.title;

import org.llaccj.yizhong.module.Clickup;
import org.llaccj.yizhong.module.Rankings;
import org.llaccj.yizhong.module.Weekbest;
import org.llaccj.yizhong.module.config.ResultInfo;
import org.llaccj.yizhong.service.common.CommonReplyMapper;
import org.llaccj.yizhong.service.common.CommonsMapper;
import org.llaccj.yizhong.service.others.WeekbestMapper;
import org.llaccj.yizhong.service.user.UserMapper;
import org.llaccj.yizhong.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ClickupServiceImpl
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-19 14:48
 * @Version
 **/
@Service
public class ClickupServiceImpl implements ClickupService {

    @Resource
    ClickupMapper clickupMapper;
    @Resource
    CommonsMapper commonsMapper;
    @Resource
    CommonReplyMapper commonReplyMapper;
    @Resource
    TitleMapper titleMapper;
    @Resource
    WeekbestMapper weekbestMapper;
    @Resource
    UserMapper userMapper;

    @Override
    public ResultInfo<Boolean> commonLike(Clickup clickup) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();

        List<Clickup> clickUp = clickupMapper.isClickUp(clickup.getClickupId(), clickup.getClickupFromUserid(), clickup.getClickupType());
        if (clickUp.isEmpty()) {
            if (clickup.getClickupType() != 1) {
                resultInfo.setSuccess(false);
                resultInfo.setMessage("1值错误");
                return resultInfo;
            }
        }else{
            //不为空 点过赞
            resultInfo.setMessage("已经点过了");
            resultInfo.setSuccess(false);
            return resultInfo;
        }
        //没有点过赞  插入
        Boolean aBoolean = clickupMapper.insertSelective(clickup);

        //点赞数 + 1
        commonsMapper.addlikenum(clickup.getClickupId());


        if (aBoolean) {
            resultInfo.setSuccess(true);
            resultInfo.setMessage("评论点赞成功");
        } else {
            resultInfo.setSuccess(false);
            resultInfo.setMessage("评论点赞失败");
        }
        return resultInfo;
    }

    @Override
    public ResultInfo<Boolean> titleLike(Clickup clickup) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();
        //判断是否已经点过
        List<Clickup> clickUp = clickupMapper.isClickUp(clickup.getClickupId(), clickup.getClickupFromUserid(), clickup.getClickupType());
        if (clickUp.isEmpty()){//为空  没有点过
            if (clickup.getClickupType() != 0) {
                resultInfo.setSuccess(false);
                resultInfo.setMessage("0值错误");
                return resultInfo;
            }
        }else {
            resultInfo.setSuccess(false);
            resultInfo.setMessage("已经点赞过");
            return resultInfo;
        }
        //点赞 插入
        Boolean aBoolean = clickupMapper.insertSelective(clickup);
        ////////////////////////
        //文章店点赞数+1
        titleMapper.addLikeNum(clickup.getClickupId());
        Integer usreidFromTitle = titleMapper.getUsreidFromTitle(clickup.getClickupId());
        userMapper.addEx(usreidFromTitle,1);
        userMapper.addGoldNum(usreidFromTitle,1);
        ////////////////////////
        if (aBoolean) {
            resultInfo.setSuccess(true);
            resultInfo.setMessage("文章点赞成功");
        } else {
            resultInfo.setSuccess(false);
            resultInfo.setMessage("文章点赞失败");
        }
        return resultInfo;
    }

    @Override
    public ResultInfo<Boolean> titleunLike(Clickup clickup) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();

        List<Clickup> clickUps = clickupMapper.isClickUp(clickup.getClickupId(), clickup.getClickupFromUserid(), clickup.getClickupType());
        if (clickUps.isEmpty()) {
            //如果为空 说明没有点过踩
            Boolean aBoolean = clickupMapper.insertSelective(clickup);
            titleMapper.addUnLikeUnm(clickup.getClickupId());
            resultInfo.setSuccess(aBoolean);
            resultInfo.setMessage("点踩成功");
            return resultInfo;
        }else {
            resultInfo.setSuccess(false);
            resultInfo.setMessage("点过踩了");
            return resultInfo;
        }
    }

    @Override
    public ResultInfo<Boolean> commonReplyLike(Clickup clickup) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();

        List<Clickup> clickUps = clickupMapper.isClickUp(clickup.getClickupId(), clickup.getClickupFromUserid(), clickup.getClickupType());

        if (clickUps.isEmpty()) {
            //为空  没点过  值不为2 错误
            if (clickup.getClickupType() != 2) {
                resultInfo.setSuccess(false);
                resultInfo.setMessage("2值错误");
                return resultInfo;
            }
        }else{
            resultInfo.setMessage("点过赞了");
            resultInfo.setSuccess(false);
            return  resultInfo;
        }


        Boolean aBoolean = clickupMapper.insertSelective(clickup);
        //回复评论表点赞
        commonReplyMapper.addlikenum(clickup.getClickupId());

        if (aBoolean) {
            resultInfo.setSuccess(true);
            resultInfo.setMessage("评论回复点赞成功");
        } else {
            resultInfo.setSuccess(false);
            resultInfo.setMessage("评论回复点赞失败");
        }
        return resultInfo;
    }

    @Override
    public ResultInfo<Boolean> isClickUp(Integer id, Integer userid, Integer type) {

        ResultInfo<Boolean> resultInfo = new ResultInfo<>();

        List<Clickup> clickUp = clickupMapper.isClickUp(id, userid, type);

        resultInfo.setSuccess(!clickUp.isEmpty());
        if (!clickUp.isEmpty()){
            resultInfo.setMessage("已经点过赞");
        }else {
            resultInfo.setMessage("未点赞");
        }

        return resultInfo;
    }

    @Override
    public void getTitleWeekBest() {
        //每周固定计算 文章
        List<Rankings> rankings = clickupMapper.CountTitleClickupWeekly();
        Rankings[] rankings1 = rankings.toArray(new Rankings[rankings.size()]);
        List<String> strings = new ArrayList<>();
        for (int i = 0; i <rankings1.length ; i++) {
            strings.add(rankings1[i].getClickup_id()+ "-"+rankings1[i].getTimes());
        }
        //文章  type:0
        weekbestMapper.insertSelective(new Weekbest(0, DateUtils.getWeekNum()-1,strings.toString()));
    }
}
