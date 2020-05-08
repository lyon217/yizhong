package org.llaccj.yizhong.service.title;

import org.llaccj.yizhong.module.Rankings;
import org.llaccj.yizhong.module.Title;
import org.llaccj.yizhong.module.TitleWithUserValue;
import org.llaccj.yizhong.module.config.ResultInfo;
import org.llaccj.yizhong.service.common.CommonReplyMapper;
import org.llaccj.yizhong.service.common.CommonsMapper;
import org.llaccj.yizhong.service.others.WeekbestService;
import org.llaccj.yizhong.service.user.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName TitleServiceImpl
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-20 17:30
 * @Version
 **/
@Service
public class TitleServiceImpl implements TitleService {
    @Resource
    TitleMapper titleMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    CommonsMapper commonsMapper;
    @Resource
    CommonReplyMapper commonReplyMapper;
    @Resource
    WeekbestService weekbestService;

    @Override
    public ResultInfo<Boolean> postTitle(Title title) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();
        titleMapper.insertSelective(title);

        resultInfo.setMessage("发布成功");
        resultInfo.setSuccess(true);

        userMapper.addTitleNum_1(title.getAuthorid());
        userMapper.addGoldNum(title.getAuthorid(), 2);
        userMapper.addEx(title.getAuthorid(), 2);

        return resultInfo;
    }

    @Override
    public ResultInfo<TitleWithUserValue> getTitleByid(Integer titleId) {
        ResultInfo<TitleWithUserValue> resultInfo = new ResultInfo<>();
        Title title = titleMapper.selectByPrimaryKey(titleId);

        if (title == null) {
            resultInfo.setMessage("无改文章");
            resultInfo.setSuccess(true);
            return resultInfo;
        }

        TitleWithUserValue titleWithUserValue = new TitleWithUserValue(title);
        String userHeadurl = userMapper.selectUserHeadurl(title.getAuthorid());
        titleWithUserValue.setAuthorheadurl(userHeadurl);
        titleWithUserValue.setContent(title.getContent());

        resultInfo.setMessage("获取成功");
        resultInfo.setSuccess(true);
        resultInfo.setData(titleWithUserValue);
        return resultInfo;
    }

    @Override
    public ResultInfo<List<TitleWithUserValue>> getTitlesViauserid(Integer userId) {
        ResultInfo<List<TitleWithUserValue>> resultInfo = new ResultInfo<>();

        List<Title> titles = titleMapper.getTitlesViauserid(userId);
        String userHeadurl = userMapper.selectUserHeadurl(userId);
        List<TitleWithUserValue> titleWithUserValues = new ArrayList<>();

        for (int i = 0; i < titles.size(); i++) {
            titleWithUserValues.add(new TitleWithUserValue(titles.get(i)));
            titleWithUserValues.get(i).setAuthorheadurl(userHeadurl);
        }

        resultInfo.setMessage("获取文章" + titles.size() + "条");
        resultInfo.setSuccess(true);
        resultInfo.setData(titleWithUserValues);
        return resultInfo;
    }

    @Override
    public ResultInfo<Boolean> deleteTitleByid(Integer userid, Integer titleid) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();

        Title title = titleMapper.selectByPrimaryKey(titleid);

        Boolean b = titleMapper.deleteTitle(userid, titleid);


        //用户文章数-1
        userMapper.reduceTitleNum_1(title.getAuthorid());

        resultInfo.setSuccess(b);
        resultInfo.setMessage("删除成功");
        resultInfo.setData(b);


        //删除该文章下所有的评论
//        commonsMapper.deleteCommonBydeleteTitle(titleId);
        //删除文章下所有的评论的回复评论
//        commonReplyMapper.deleteBydeletTitle(titleId);

        return resultInfo;
    }

    @Override
    public List<Title> getTitleListBydefault() {
        List<Title> titles = titleMapper.getTitleListBydefault();
        Collections.shuffle(titles);
//        List<Title> titles1 = titles.subList(0, 10);
        return titles;
    }

    @Override
    public List<Title> getTitleListByTime() {
        List<Title> titles = titleMapper.getTitleListByTime();
        return titles;
    }

    @Override
    public List<Title> getTitleListByclass(Integer classone, Integer classtwo) {
        List<Title> titles = titleMapper.getTitleListByClass(classone, classtwo);
        return titles;
    }

    @Override
    public ResultInfo<List<Title>> searchTitle(String titlename) {
        ResultInfo<List<Title>> resultInfo = new ResultInfo<>();
        if (titlename.length() <= 0) {
            resultInfo.setSuccess(false);
            resultInfo.setData(null);
            resultInfo.setMessage("没有相关帖子");
            return resultInfo;
        }

        List<Title> titles = titleMapper.searchTitle(titlename);
        resultInfo.setData(titles);
        resultInfo.setMessage("共计" + titles.size() + "条");
        resultInfo.setSuccess(true);
        return resultInfo;
    }

    @Override
    public ResultInfo<List<Title>> getTitleClickupRanking(Integer week) {
        ResultInfo<List<Title>> resultInfo = new ResultInfo<>();
        List<Rankings> titleClickupRanking = weekbestService.getTitleRankinglist(week);
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < titleClickupRanking.size(); i++) {
            map.put(titleClickupRanking.get(i).getClickup_id(), titleClickupRanking.get(i).getTimes());
        }

        List<Title> titles = titleMapper.getWeekBestTitle(titleClickupRanking);
        for (int i = 0; i < titles.size(); i++) {
//            if (titles.get(i) != null) {
//                titles.get(i).setLikenum(titleClickupRanking.get(i).getTimes());
                titles.get(i).setLikenum(map.get(titles.get(i).getId()));
//            } else {
//                continue;
//            }
        }

        Map<Integer, Title> map2 = new TreeMap<>();

        for (int i = 0; i < titles.size(); i++) {
//            if (titles.get(i) != null) {
                map2.put(titles.get(i).getId(), titles.get(i));
//            }
        }

        titles.clear();
        for (int i = 0; i < map.size(); i++) {
            if(map2.get(titleClickupRanking.get(i).getClickup_id())!=null)
            {
                titles.add(map2.get(titleClickupRanking.get(i).getClickup_id()));
            }
        }

        List<Title> titles1 = new ArrayList<>();
        for (int i = 0; i < titles.size() && titles1.size() <= 10; i++) {
            if (titles.get(i) != null) {
                titles1.add(titles.get(i));
            }
        }


        resultInfo.setSuccess(true);
        resultInfo.setData(titles1);
        return resultInfo;
    }

}
