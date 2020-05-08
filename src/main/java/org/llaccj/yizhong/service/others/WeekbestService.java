package org.llaccj.yizhong.service.others;

import org.llaccj.yizhong.module.Rankings;

import java.util.List;

/**
 * @ClassName WeekService
 * @Description TODO
 * @Author Lyon
 * @Date 2020-05-06 18:54
 * @Version
 **/
public interface WeekbestService {

    List<Rankings> getTitleRankinglist(Integer week);
}
