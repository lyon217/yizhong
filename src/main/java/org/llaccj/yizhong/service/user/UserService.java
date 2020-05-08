package org.llaccj.yizhong.service.user;

import org.llaccj.yizhong.module.User;
import org.llaccj.yizhong.module.config.ResultInfo;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-16 21:48
 * @Version
 **/
public interface UserService {

    //普通用户登录
    ResultInfo<User> userLogin(String TelOrEmail, String password);

    //用户名是否重复验证
    ResultInfo<Boolean> uIsmul(String uName, String uTel, String uEmail);

    //用户注册
    ResultInfo<User> addUserSelective(User user);

    //更新用户信息
    ResultInfo<Boolean> updateUserSelect(User user);

    //按照用户名进行模糊搜索
    ResultInfo<List<User>> searchUserByname(String name);
    //解禁某一用户
    ResultInfo<Boolean> enableUser(Integer id);

    ResultInfo<User> searchUserByid(Integer id);

    //发布文章 用户文章数+1
    Boolean addTitleNum_1(int id);

    //用户发布文章 金币+5 被点赞金币+1
    Boolean addGoldNum(int id, int num);

    //管理员禁用某一用户
    ResultInfo<Boolean> disableUser(Integer id);


    ResultInfo<Boolean> deleteUser(Integer id);

    List<User> getAllusers();

    void countUserWeekBest();

    ResultInfo<List<User>> getUserWeekBest(Integer week);
}
