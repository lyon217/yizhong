package org.llaccj.yizhong.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.llaccj.yizhong.module.User;
import org.llaccj.yizhong.module.config.ResultInfo;
import org.llaccj.yizhong.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserLoginController
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-15 10:03
 * @Version
 **/

@Api(tags = {"user-用户登录,注册,验证Tel或Email是否已经注册,根据用户名或者是用户id查询用户全部信息"})
@RestController
public class UserLoginController {

    @Resource
    UserService userService;


    @PostMapping("/userlogin")
    @ApiOperation(value = "用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "teloremail",value = "用户电话或者是邮箱",required = true,dataType = "String"),
            @ApiImplicitParam(name = "password",value = "密码",required = true,dataType = "String")
    })
    public ResultInfo<User> Userlogin(@RequestParam("teloremail") String teloremail,
                                          @RequestParam("password") String password) {
        return userService.userLogin(teloremail, password);
    }

    @GetMapping("/uismul")
    @ApiOperation("验证用户名,电话号,邮箱是否已经注册,可传其中一个,可都传  true:重复,false:不重复")
    @ApiImplicitParams({
            @ApiImplicitParam(name="uName",value = "用户名",required = false, dataType = "String"),
            @ApiImplicitParam(name="uTel",value = "电话号",required = false, dataType = "String"),
            @ApiImplicitParam(name="uEmail",value = "邮箱",required = false, dataType = "String")
    })
    public ResultInfo<Boolean> uNameIsmul (
            @RequestParam(value = "uName",required = false) String uName,
            @RequestParam(value = "uTel",required = false) String uTel,
            @RequestParam(value = "uEmail",required = false) String uEmail){

        return userService.uIsmul(uName,uTel,uEmail);
    }

    @PostMapping(value = "/user", produces = "application/json")
    @ApiOperation(value = "用户注册接口")
    public ResultInfo<User> userRegister(@RequestBody User user){
        return userService.addUserSelective(user);
    }

    @PutMapping("/user")
    @ApiOperation("用户信息更新  --(用户ID必须有,登录验证通过之用户数据已经全部返回)")
    public ResultInfo<Boolean> userUpdate(@RequestBody User user){
        return userService.updateUserSelect(user);
    }

    @GetMapping("/searchuserbyname")
    @ApiOperation("根据用户名进行模糊搜索所有匹配的用户信息  匹配规则 '%输入字段%' ")
    @ApiImplicitParam(name = "name",value = "输入的用户名",paramType = "query",dataType = "String",required = true)
    public ResultInfo<List<User>> searchUserByname(@RequestParam String name){
        return userService.searchUserByname(name);
    }

    @GetMapping("/searchuserbyid")
    @ApiOperation("根据用户id查询用户信息")
    @ApiImplicitParam(name = "id",value = "用户id",paramType = "query",dataType = "int",required = true)
    public ResultInfo<User> searchUserByid(@RequestParam Integer id){
        return userService.searchUserByid(id);
    }

    @PutMapping("/userdisable")
    @ApiOperation("禁用某一用户")
    @ApiImplicitParam(name = "id",value = "id",dataType = "int")
    public ResultInfo<Boolean> disableUser(@RequestParam Integer id){
        return userService.disableUser(id);
    }
    @PutMapping("/userenable")
    @ApiOperation("解禁某一用户")
    @ApiImplicitParam(name = "id",value = "id",dataType = "int")
    public ResultInfo<Boolean> enableUser(@RequestParam Integer id){
        return userService.enableUser(id);
    }

    @DeleteMapping("/user")
    @ApiOperation("删除某一用户")
    @ApiImplicitParam(name = "id",value = "用户id",dataType = "int",paramType = "query")
    public ResultInfo<Boolean> deleteUser(@RequestParam Integer id){
        return userService.deleteUser(id);
    }





//    @ApiOperation(value = "这个什么都不是")
//    @PostMapping(value = "/usertest",produces = "application/json")
//    public void Usertest (@RequestBody User user){
//        System.out.println(user.toString());
//    }
//    @ApiOperation(value = "这个什么都不是")
//    @PostMapping(value = "/usertest2",produces = "application/json")
//    public void Usertest2 (@RequestParam String a){
//        System.out.println(a);
//    }
}
