package org.llaccj.yizhong.controller;

import org.llaccj.yizhong.service.title.ClickupMapper;
import org.llaccj.yizhong.service.title.ClickupService;
import org.llaccj.yizhong.service.title.TitleService;
import org.llaccj.yizhong.utils.IPUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-30 20:45
 * @Version
 **/
@RestController
public class TestController {

    @Resource
    ClickupMapper clickupMapper;
    @Resource
    ClickupService clickupService;
    @Resource
    TitleService titleService;

    @GetMapping("/ipconfig")
    public void getid(HttpServletRequest req) {
        String ipAddr = IPUtils.getIpAddr(req);
        System.out.println(ipAddr + "----------");
    }

    @GetMapping("/2")
    public void get2() {
    }

    @GetMapping("/test3")
    public void test3(@RequestParam Integer id) {

//        System.out.println(id.equals(null));
        System.out.println(id == null);

    }

    @GetMapping("/tese4")
    public void getTitleClickup() {
        clickupService.getTitleWeekBest();
    }
}
