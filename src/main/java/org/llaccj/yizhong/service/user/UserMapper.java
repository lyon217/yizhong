package org.llaccj.yizhong.service.user;

import org.apache.ibatis.annotations.Mapper;
import org.llaccj.yizhong.module.Rankings;
import org.llaccj.yizhong.module.Subscribe;
import org.llaccj.yizhong.module.User;

import java.util.List;

@Mapper
public interface UserMapper {

    //用户登录  账号密码验证
    List<User> userLogin(String TelOrEmail,String password);
    //验证用户名是否已经注册
    boolean uIsmul(String uName,String uTel,String uEmail);
    //注册用户  选择性存在属性进行插入
    boolean insertSelective(User record);
    //按照用户的Tel或者是Email进行查找用户信息
    List<User> selectByTelorEmail(String uTel,String uEmail);
    //选择性的更新用户信息
    Boolean updateByPrimaryKeySelective(User record);
    //按照用户民进行模糊搜索用户
    List<User> searchUserByname(String name);
    //按照用户id进行搜索用户
    User searchUserByid(Integer id);
    //禁用某一用户
    Boolean disableUser(Integer id);
    //解禁用户
    Boolean enableUser(Integer id);
    //查看粉丝时 ,  根据关注表,拿到id的list  来获取userlist
    List<User> selectFansByIdList(List<Subscribe> subscribes);
    //查看关注时,根据关注表 拿到idlist  获取userlist
    List<User> selectSubsByIdList(List<Subscribe> subscribes);
    //根据用户id获取用户头像
    String selectUserHeadurl(Integer id);
    //获取用户金币数  用来判断 是不是能够兑换
    int selectGoldNum(Integer id);
    //删除一个用户
    Boolean deleteByPrimaryKey(Integer uId);
    //获取全部用户  分页
    List<User> selectAlluser();

    int selectUserStatus(Integer id);






    int insert(User record);

    User selectByPrimaryKey(Integer uId);

    int updateByPrimaryKey(User record);

    //用户文章数+1  -1
    Boolean addTitleNum_1(Integer id);
    Boolean reduceTitleNum_1(Integer id);

    //用户收藏数+1
//    Boolean addCollectNum(Integer collectUserid);
    //用户收藏数-1
//    Boolean reduceCollectNum(Integer collectUserid);


    Boolean addGoldNum(Integer id,Integer num);
    Boolean addEx(Integer id,Integer num);
    Boolean reduceGoldNum(Integer id,Integer num);


    List<Rankings> countUserex();

    List<User> getUserByIds(List<Integer> userids);
}