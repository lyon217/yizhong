package org.llaccj.yizhong.controller.others;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.llaccj.yizhong.module.Subscribe;
import org.llaccj.yizhong.module.User;
import org.llaccj.yizhong.module.config.ResultInfo;
import org.llaccj.yizhong.service.others.SubscribeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName SubscribeController
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-22 21:05
 * @Version
 **/
@Api(tags = "关注,取消关注,用户查看关注和粉丝")
@RestController
public class SubscribeController {

    @Resource
    SubscribeService subscribeService;

    @ApiOperation("关注")
    @PostMapping(value = "/subscribe",consumes = "application/json;charset=utf-8")
    public ResultInfo<Boolean> addSubscribe(@RequestBody Subscribe subscribe){
        return subscribeService.addSubscribe(subscribe);
    }

    @ApiOperation("取消关注")
    @DeleteMapping(value = "/subscribe",consumes = "application/json;charset=utf-8")
//    @ApiImplicitParam(name = "id",value = "关注列表的自增id",dataType = "int")
    public ResultInfo<Boolean> deleteSubscribe(@RequestBody Subscribe subscribe){
        return subscribeService.deleteSubscribe(subscribe);
    }

    @ApiOperation("查看关注总数")
    @ApiImplicitParam(name = "id",value = "用户id",paramType = "query",dataType = "int")
    @GetMapping("/subscribenum")
    public ResultInfo<Integer> getSubscribeNum(@RequestParam Integer id){
        return subscribeService.getSubscribeNum(id);
    }


    @ApiOperation("查看自己的所有关注")
    @ApiImplicitParam(name = "id",value = "用户id",paramType = "query",dataType = "int")
    @GetMapping("/subscribe")
    public ResultInfo<List<User>> getSubscribes(@RequestParam Integer id){
        return subscribeService.getSubscribes(id);
    }

    @ApiOperation("查看自己的所有粉丝")
    @ApiImplicitParam(name = "id",value = "用户id",paramType = "query",dataType = "int")
    @GetMapping("/fans")
    public ResultInfo<List<User>> getFensi(@RequestParam Integer id){
        return subscribeService.getFensi(id);
    }

    @ApiOperation("查看自己的粉丝数")
    @ApiImplicitParam(name = "id",value = "用户id",paramType = "query",dataType = "int")
    @GetMapping("/fansnum")
    public ResultInfo<Integer> getFensiNum(@RequestParam Integer id){
        return subscribeService.getFensiNum(id);
    }


    @ApiOperation("查看A是否关注B")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ida",value = "点击关注的用户a",paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "idb",value = "被关注的用户b",paramType = "query",dataType = "int")
    })
    @GetMapping("/isfans")
    public ResultInfo<Boolean> getIsSubscribe(
            @RequestParam Integer ida,
            @RequestParam Integer idb){
        return subscribeService.getIsSubscribe(ida,idb);
    }

}
