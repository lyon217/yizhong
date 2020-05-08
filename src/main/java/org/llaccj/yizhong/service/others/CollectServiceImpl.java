package org.llaccj.yizhong.service.others;

import org.llaccj.yizhong.module.Collect;
import org.llaccj.yizhong.module.Title;
import org.llaccj.yizhong.module.TitleWithUserValue;
import org.llaccj.yizhong.module.config.ResultInfo;
import org.llaccj.yizhong.service.title.TitleMapper;
import org.llaccj.yizhong.service.user.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CollectServiceImpl
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-22 20:35
 * @Version
 **/
@Service
public class CollectServiceImpl implements CollectService {
    @Resource
    CollectMapper collectMapper;
    @Resource
    TitleMapper titleMapper;
    @Resource
    UserMapper userMapper;

    @Override
    public ResultInfo<Boolean> addCollect(Collect collect) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();

        List<Collect> isCollected = collectMapper.getIsCollected(collect.getCollectUserid(), collect.getCollectId());

        if (isCollected.isEmpty()) {
            //如果为空  insert
            Boolean aBoolean = collectMapper.insertSelective(collect);
            //收藏数+1 数据库表中没有收藏数字段  mapper也没实现
//            userMapper.addCollectNum(collect.getCollectUserid());
            titleMapper.addCollectNum(collect.getCollectId());
            resultInfo.setSuccess(aBoolean);
            resultInfo.setMessage("收藏成功");
        } else {
            resultInfo.setSuccess(false);
            resultInfo.setMessage("已经收藏");
        }

        return resultInfo;
    }

    @Override
    public ResultInfo<Boolean> deleteCollect(Collect collect) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();
        Boolean aBoolean = collectMapper.deleteCollect(collect);
        titleMapper.reduceCollectNum(collect.getCollectId());

        resultInfo.setSuccess(aBoolean);
        resultInfo.setMessage("取消收藏成功");

        return resultInfo;
    }

    @Override
    public ResultInfo<List<TitleWithUserValue>> getCollectsByUserid(Integer userId) {
        ResultInfo<List<TitleWithUserValue>> resultInfo = new ResultInfo<>();
        List<TitleWithUserValue> titleWithUserValues = new ArrayList<>();

        List<Collect> collects = collectMapper.getCollectsByUserid(userId);
        if(collects.isEmpty()){
            resultInfo.setData(null);
            resultInfo.setSuccess(true);
            resultInfo.setMessage("共收藏0条");
            return resultInfo;
        }

        String userHeadurl = userMapper.selectUserHeadurl(userId);

        List<Title> titles = titleMapper.getCollectTitles(collects);

        for (int i = 0; i <titles.size() ; i++) {
             titleWithUserValues.add(new TitleWithUserValue(titles.get(i)));
             titleWithUserValues.get(i).setAuthorheadurl(userHeadurl);
        }

        resultInfo.setData(titleWithUserValues);
        resultInfo.setSuccess(true);
        resultInfo.setMessage("共收藏" + titleWithUserValues.size() + "条");
        return resultInfo;
    }

    @Override
    public ResultInfo<Boolean> isCollected(Integer userId, Integer titleId) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();

        List<Collect> isCollected = collectMapper.getIsCollected(userId, titleId);

        if (isCollected.isEmpty()) {
            resultInfo.setMessage("未收藏");
        } else {
            resultInfo.setMessage("已经收藏");
        }
        resultInfo.setSuccess(!isCollected.isEmpty());

        return resultInfo;
    }


}
