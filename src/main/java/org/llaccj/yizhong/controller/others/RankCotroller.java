package org.llaccj.yizhong.controller.others;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.llaccj.yizhong.module.Title;
import org.llaccj.yizhong.module.User;
import org.llaccj.yizhong.module.config.ResultInfo;
import org.llaccj.yizhong.service.title.TitleService;
import org.llaccj.yizhong.service.user.UserService;
import org.llaccj.yizhong.utils.DateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName RankCotroller
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-21 11:04
 * @Version
 **/
@RestController
@Api("排行榜")
public class RankCotroller {

    @Resource
    TitleService titleService;
    @Resource
    UserService userService;


    @ApiOperation("帖子周点赞榜")
    @ApiImplicitParam(name = "week", value = "周数", dataType = "int", paramType = "query")
    @GetMapping("/titleranking")
    public ResultInfo<List<Title>> getTitleClickupRanking(@RequestParam(required = false) Integer week) {
        if (week == null) {
            week = DateUtils.getWeekNum() - 1;
        }
        return titleService.getTitleClickupRanking(week);
    }

    @ApiOperation("达人榜")
    @ApiImplicitParam(name = "week", value = "周数", dataType = "int", paramType = "query")
    @GetMapping("/userranking")
    public ResultInfo<List<User>> getUsrRanking(@RequestParam(required = false) Integer week) {
        if (week == null) {
            week = DateUtils.getWeekNum() - 1;
        }
        return userService.getUserWeekBest(week);
    }



}
