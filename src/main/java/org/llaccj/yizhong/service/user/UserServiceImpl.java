package org.llaccj.yizhong.service.user;

import org.llaccj.yizhong.module.Rankings;
import org.llaccj.yizhong.module.User;
import org.llaccj.yizhong.module.Weekbest;
import org.llaccj.yizhong.module.config.ResultInfo;
import org.llaccj.yizhong.service.others.WeekbestMapper;
import org.llaccj.yizhong.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-16 21:49
 * @Version
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;
    @Resource
    WeekbestMapper weekbestMapper;

    @Override
    public ResultInfo<User> userLogin(String TelOrEmail, String password) {
        ResultInfo<User> resultInfo = new ResultInfo<>();

        List<User> users = userMapper.userLogin(TelOrEmail, password);

        int i = userMapper.selectUserStatus(users.get(0).getuId());
        if(i == 0){
            resultInfo.setData(null);
            resultInfo.setMessage("用户被禁用");
            resultInfo.setSuccess(false);
        }


//
        if (users.isEmpty()) {
            resultInfo.setSuccess(false);
            resultInfo.setCode(101);
            resultInfo.setMessage("登录失败,请重新检查您输入的账号密码~");
            resultInfo.setData(null);
        }else{
            resultInfo.setSuccess(true);
            resultInfo.setCode(null);
            resultInfo.setMessage("登录成功");
            resultInfo.setData(users.get(0));
        }
        return resultInfo;
    }

    @Override
    public ResultInfo<Boolean> uIsmul(String uName,String uTel,String uEmail) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();
        boolean b = userMapper.uIsmul( uName, uTel, uEmail);
        resultInfo.setSuccess(true);
        if (b){
            resultInfo.setData(true);
            resultInfo.setMessage("已经注册过了");
        }else {
            resultInfo.setData(false);
            resultInfo.setMessage("用户暂时未注册");
        }
        resultInfo.setCode(0);
        return resultInfo;
    }

    @Override
    public ResultInfo<User> addUserSelective(User user){
        ResultInfo<User> resultInfo = new ResultInfo<>();

        //如果电话或者是邮箱已经注册  直接返回false
        List<User> users1 = userMapper.selectByTelorEmail(user.getuTel(), user.getuEmail());
        if(users1.size()>0){
            resultInfo.setSuccess(false);
            resultInfo.setMessage("该电话或邮箱已经注册");
            return resultInfo;
        }

        //如果没有注册,就进行插入操作
        boolean i = userMapper.insertSelective(user);
        List<User> users = userMapper.selectByTelorEmail(user.getuTel(),user.getuEmail());

//        //设置默认用户名
//        User user1 = new User();
//        if(user.getuTel().isEmpty()){
//            user1.setuName(user.getuEmail());
//            user1.setuId(users.get(0).getuId());
//            users.get(0).setuName(user.getuEmail());
//        }else {
//            user1.setuName(user.getuTel());
//            user1.setuId(users.get(0).getuId());
//            users.get(0).setuName(user.getuTel());
//        }
//        userMapper.updateByPrimaryKeySelective(user1);

        if (i){
            resultInfo.setSuccess(true);
            resultInfo.setData(users.get(0));
            resultInfo.setMessage("用户注册成功,请尽快完善个人信息");
        }else {
            resultInfo.setSuccess(false);
            resultInfo.setMessage("用户注册失败......");
        }
        return resultInfo;
    }

    @Override
    public ResultInfo<Boolean> updateUserSelect(User user){
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();
        Boolean i = userMapper.updateByPrimaryKeySelective(user);
        if(i){
            resultInfo.setSuccess(true);
            resultInfo.setMessage("用户信息更新完成");
            resultInfo.setData(true);
        }else{
            resultInfo.setSuccess(false);
        }
        return resultInfo;
    }

    @Override
    public ResultInfo<List<User>> searchUserByname(String name) {
        ResultInfo<List<User>> resultInfo = new ResultInfo<>();
        ArrayList<User> a = new ArrayList<>();

        if(name.length()<=0){
            resultInfo.setMessage("无相关用户");
            resultInfo.setSuccess(true);
            return resultInfo;
        }
        List<User> users = userMapper.searchUserByname(name);
        a.addAll(users);

        resultInfo.setCode(users.size());
        resultInfo.setSuccess(true);
        resultInfo.setData(a);
        resultInfo.setMessage("共搜索获得相关用户"+users.size()+"条");

        return resultInfo;
    }

    @Override
    public ResultInfo<Boolean> enableUser(Integer id) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();
        Boolean b = userMapper.enableUser(id);
        resultInfo.setSuccess(b);
        resultInfo.setMessage("解禁成功");
        return resultInfo;
    }

    @Override
    public ResultInfo<User> searchUserByid(Integer id) {
        ResultInfo<User> resultInfo = new ResultInfo<>();
        if(id==null){
            resultInfo.setMessage("无相关用户");
            resultInfo.setSuccess(true);
            return resultInfo;
        }
        User user = userMapper.searchUserByid(id);
        if (user==null){
            resultInfo.setSuccess(true);
            resultInfo.setMessage("用户不存在");
            return resultInfo;
        }
        resultInfo.setSuccess(true);
        resultInfo.setData(user);
        return resultInfo;
    }

    @Override
    public ResultInfo<Boolean> disableUser(Integer id) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();
        Boolean b = userMapper.disableUser(id);
        resultInfo.setSuccess(b);
        resultInfo.setMessage("禁用成功");
        return resultInfo;
    }

    @Override
    public ResultInfo<Boolean> deleteUser(Integer id) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();
        Boolean b = userMapper.deleteByPrimaryKey(id);
        resultInfo.setSuccess(b);
        resultInfo.setMessage("删除成功");
        return resultInfo;
    }

    @Override
    public List<User> getAllusers() {
        return userMapper.selectAlluser();
    }

    @Override
    public void countUserWeekBest() {
        List<Rankings> rankings = userMapper.countUserex();
        Rankings[] rankings1 = rankings.toArray(new Rankings[rankings.size()]);
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i <rankings1.length ; i++) {
            integers.add(rankings1[i].getClickup_id());
        }
        //达人  type:1
        weekbestMapper.insertSelective(new Weekbest(1, DateUtils.getWeekNum(),integers.toString()));
    }

    @Override
    public ResultInfo<List<User>> getUserWeekBest(Integer week) {
        ResultInfo<List<User>> resultInfo = new ResultInfo<>();

        Weekbest userWeekBest = weekbestMapper.getUserWeekBest(week);
        String userlist = userWeekBest.getContent();
        String weekbest = userlist.substring(1,userlist.length()-2);
        String[] ids = weekbest.split(",");
        List<Integer> userids = new ArrayList<>();
        for (int i = 0; i <ids.length ; i++) {
            userids.add(Integer.parseInt(ids[i].trim()));
        }

        List<User> users = userMapper.getUserByIds(userids);
        List<User> users1 = users.subList(0, 10);
        resultInfo.setData(users1);
        resultInfo.setSuccess(true);
        return resultInfo;

    }


    @Override
    public Boolean addTitleNum_1(int id){
        return userMapper.addTitleNum_1(id);
    }
    @Override
    public Boolean addGoldNum(int id,int num){
        return userMapper.addGoldNum(id,num);
    }
}
