package org.llaccj.yizhong.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.llaccj.yizhong.module.AdminTable;
import org.llaccj.yizhong.module.User;
import org.llaccj.yizhong.module.config.ResultInfo;
import org.llaccj.yizhong.service.admin.AdminService;
import org.llaccj.yizhong.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName AdminController
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-18 20:39
 * @Version
 **/
@Api(tags = "管理员登录,修改密码,查看所有用户")
@RestController
public class AdminController {
    @Resource
    AdminService adminService;
    @Resource
    UserService userService;


    @PutMapping("/adminlogin")
    @ApiOperation(value = "管理员登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aName",value = "管理员名称",required = true,dataType = "String"),
            @ApiImplicitParam(name = "aPassword",value = "管理员密码",required = true,dataType = "String")
    })
    public ResultInfo<AdminTable> AdminLogin(
            @RequestParam("aName")String aName,
            @RequestParam("aPassword")String aPassword){
    return adminService.AdminLogin(aName,aPassword);
    }

    @PutMapping("/admin")
    @ApiOperation("管理员修改密码")
    public ResultInfo<Boolean> updatePassofAdmin(@RequestBody AdminTable adminTable){
        return adminService.updateAdmin(adminTable);
    }

    @GetMapping("/user")
    @ApiImplicitParam(name = "page",value = "页数",paramType = "query",dataType = "int")
    public ResultInfo<PageInfo<User>> getAllUsers(@RequestParam Integer page){
        PageHelper.startPage(page,10);
        List<User> list = userService.getAllusers();
        PageInfo<User> pageInfo = new PageInfo<User>(list);

        ResultInfo<PageInfo<User>> resultInfo = new ResultInfo<>();

        resultInfo.setSuccess(true);
        resultInfo.setData(pageInfo);
        return resultInfo;
    }

}
