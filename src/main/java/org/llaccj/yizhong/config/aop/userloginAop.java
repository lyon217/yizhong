package org.llaccj.yizhong.config.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName userloginAop
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-17 11:47
 * @Version
 **/
@Aspect
@Component
public class userloginAop {

    //主要处理用户登录  userLoginController 中返回数据的封装
    @Pointcut()
    public void pc1(){}



}
