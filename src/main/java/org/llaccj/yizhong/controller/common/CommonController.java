package org.llaccj.yizhong.controller.common;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.llaccj.yizhong.module.Clickup;
import org.llaccj.yizhong.module.CommonReply;
import org.llaccj.yizhong.module.CommonWithUserValue;
import org.llaccj.yizhong.module.Commons;
import org.llaccj.yizhong.module.config.ResultInfo;
import org.llaccj.yizhong.service.common.CommonReplyService;
import org.llaccj.yizhong.service.common.CommonService;
import org.llaccj.yizhong.service.title.ClickupService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName CommonController
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-19 14:28
 * @Version
 **/
@RestController
@Api(tags = {"普通用户给文章评论",""})
public class CommonController {

    @Resource
    CommonService commonService;
    @Resource
    CommonReplyService commonReplyService;
    @Resource
    ClickupService clickupService;

    @ApiOperation(value = "用户给文章评论")
    @PostMapping(value = "/common",consumes = "application/json;charset=utf-8")
    public ResultInfo<Boolean> userCommon(@RequestBody Commons commons){
        return commonService.userCommon(commons);
    }

    @ApiOperation(value = "获取该文章所有评论")
    @ApiImplicitParam(value = "文章id",name = "id",required = true,paramType = "query",dataType = "int")
    @GetMapping("/common")
    public ResultInfo<List<CommonWithUserValue>> getCommons(Integer id){
        return commonService.getcommons(id);
    }

    @ApiOperation("用户查看自己的对文章的所有评论")
    @ApiImplicitParam(value = "用户id",name = "id",required = true,paramType = "query",dataType = "int")
    @GetMapping("/personalcommon")
    public ResultInfo<List<Commons>> getPersonalCommon(@RequestParam Integer id){
        return commonService.getPersonalCommons(id);
    }



    @ApiOperation(value = "给评论点赞",notes = "clickupType=1,id与time不要",consumes = "application/json;charset=utf-8")
    @PostMapping("/commonlike")
    public ResultInfo<Boolean> commonLike(@RequestBody Clickup clickup){
        return clickupService.commonLike(clickup);
    }


    @ApiOperation("回复评论")
    @PostMapping("/commonreply")
    public ResultInfo<Boolean> commonReply(@RequestBody CommonReply commonReply){
        return commonService.commonReply(commonReply);
    }


    @ApiOperation(value = "获取某一评论的所有回复评论")
    @GetMapping("/commonreply")
    @ApiImplicitParam(value = "评论id",name = "id",required = true,dataType = "int",paramType = "query")
    public ResultInfo<List<CommonReply>> getCommonReply(@RequestParam(value = "id") Integer id){
        return commonReplyService.getCommonReply(id);
    }


    @ApiOperation(value = "给回复的评论点赞   clickupType=2",consumes = "application/json;charset=utf-8")
    @PostMapping("/commonreplylike")
    public ResultInfo<Boolean> commonReplyLike(@RequestBody Clickup clickup){
        return clickupService.commonReplyLike(clickup);
    }

    @ApiOperation("删除评论")
    @DeleteMapping("/common")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "评论id",dataType = "int",paramType = "query")
    })
    public ResultInfo<Boolean> deleteCommon(@RequestParam Integer id){
        return commonService.deleteCommon(id);
    }



}
