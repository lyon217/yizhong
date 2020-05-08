package org.llaccj.yizhong.service.others;

import org.llaccj.yizhong.module.Subscribe;
import org.llaccj.yizhong.module.User;
import org.llaccj.yizhong.module.config.ResultInfo;
import org.llaccj.yizhong.service.user.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SubscribeServiceImpl
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-22 20:36
 * @Version
 **/
@Service
public class SubscribeServiceImpl implements SubscribeService {
    @Resource
    SubscribeMapper subscribeMapper;
    @Resource
    UserMapper userMapper;

    @Override
    public ResultInfo<Boolean> addSubscribe(Subscribe subscribe) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();

        List<Subscribe> subscribes = subscribeMapper.getisSubscribe(subscribe.getSubscribeUserid(), subscribe.getSubscribeId());

        if (subscribes.isEmpty()) {
            Boolean aBoolean = subscribeMapper.insertSelective(subscribe);
            resultInfo.setSuccess(true);
            resultInfo.setMessage("关注成功");
            return resultInfo;
        } else {
            resultInfo.setSuccess(false);
            resultInfo.setMessage("已经关注过了");
            return resultInfo;
        }
    }

    @Override
    public ResultInfo<Boolean> deleteSubscribe(Subscribe subscribe) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();

        Boolean aBoolean = subscribeMapper.deleteSubscribe(subscribe);

        resultInfo.setSuccess(aBoolean);
        resultInfo.setMessage("取消关注成功");

        return resultInfo;
    }

    @Override
    public ResultInfo<List<User>> getSubscribes(Integer id) {
        ResultInfo<List<User>> resultInfo = new ResultInfo<>();

        List<Subscribe> subscribes = subscribeMapper.getguanzhu(id);
        if (subscribes.isEmpty()) {
            resultInfo.setSuccess(true);
            resultInfo.setMessage("无关注用户");
            return resultInfo;
        }

        List<User> users = userMapper.selectSubsByIdList(subscribes);

        resultInfo.setData(users);
        resultInfo.setSuccess(true);
        resultInfo.setMessage("共关注了" + users.size() + "个用户");
        return resultInfo;
    }

    @Override
    public ResultInfo<List<User>> getFensi(Integer id) {
        ResultInfo<List<User>> resultInfo = new ResultInfo<>();

        List<Subscribe> subscribes = subscribeMapper.getFensi(id);
        List<User> users = new ArrayList<>();

        if (subscribes.size() >= 1) {
            users = userMapper.selectFansByIdList(subscribes);
            resultInfo.setData(users);
            resultInfo.setSuccess(true);
            resultInfo.setMessage("共有" + users.size() + "个用户关注了你");
            return resultInfo;
        }else {
            resultInfo.setSuccess(true);
            resultInfo.setMessage("无粉丝");
            resultInfo.setData(null);
            return resultInfo;
        }
    }

    @Override
    public ResultInfo<Boolean> getIsSubscribe(Integer ida, Integer idb) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();

        List<Subscribe> subscribes = subscribeMapper.getisSubscribe(ida, idb);
        resultInfo.setSuccess(!subscribes.isEmpty());
        if (!subscribes.isEmpty()) {
            resultInfo.setMessage("已经关注");
        } else {
            resultInfo.setMessage("未关注");
        }
        return resultInfo;
    }

    @Override
    public ResultInfo<Integer> getSubscribeNum(Integer id) {
        ResultInfo<Integer> resultInfo = new ResultInfo<>();
        if(id==null){
            resultInfo.setMessage("id为null");
            resultInfo.setSuccess(true);
            return resultInfo;
        }
        Integer num = subscribeMapper.getSubscribenum(id);

        resultInfo.setSuccess(true);
        resultInfo.setData(num);
        return resultInfo;
    }

    @Override
    public ResultInfo<Integer> getFensiNum(Integer id) {
        ResultInfo<Integer> resultInfo = new ResultInfo<>();
        if(id==null){
            resultInfo.setMessage("id为null");
            resultInfo.setSuccess(true);
            return resultInfo;
        }
        Integer num = subscribeMapper.selectFensiNum(id);

        resultInfo.setSuccess(true);
        resultInfo.setData(num);
        return resultInfo;
    }
}
