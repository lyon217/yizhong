package org.llaccj.yizhong.service.others;

import org.llaccj.yizhong.module.Rankings;
import org.llaccj.yizhong.module.Weekbest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName WeekbestServiceImpl
 * @Description TODO
 * @Author Lyon
 * @Date 2020-05-06 18:54
 * @Version
 **/
@Service
public class WeekbestServiceImpl implements WeekbestService {

    @Resource
    WeekbestMapper weekbestMapper;

    @Override
    public List<Rankings> getTitleRankinglist(Integer week) {
        //从weekbest获取排行列表
        Weekbest weekbest = weekbestMapper.GetTitleClickupRanking(week);
        //将列表解析为titleid数组
        String content = weekbest.getContent();
        String substring = content.substring(1, content.length() - 1);
        String[] split = substring.split(",");
        List<Rankings> a = new ArrayList<>();
//        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split("-");
            String id = split1[0].trim();
            String time = split1[1].trim();
            a.add(new Rankings(Integer.parseInt(id.trim()),Integer.parseInt(time.trim())));
//            map.put(Integer.parseInt(id.trim()),Integer.parseInt(time.trim()));
        }
        return a;
    }
}
