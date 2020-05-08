package org.llaccj.yizhong.config.runner;

import org.llaccj.yizhong.service.title.ClickupService;
import org.llaccj.yizhong.service.user.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName TitleWeekBestRunner
 * @Description TODO
 * @Author Lyon
 * @Date 2020-05-07 9:42
 * @Version
 **/
@Component
@Configuration
@EnableScheduling
public class TitleWeekBestRunner {
    @Resource
    ClickupService clickupService;
    @Resource
    UserService userService;

    @Scheduled(cron = "0 0 3 ? * MON")
    public void countTitleWeekBest(){
        clickupService.getTitleWeekBest();
        userService.countUserWeekBest();
    }
}
