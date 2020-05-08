package org.llaccj.yizhong.controller.others;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.llaccj.yizhong.module.Collect;
import org.llaccj.yizhong.module.TitleWithUserValue;
import org.llaccj.yizhong.module.config.ResultInfo;
import org.llaccj.yizhong.service.others.CollectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName CollectController
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-22 20:35
 * @Version
 **/
@RestController
@Api(tags = "收藏,取消收藏,用户查看收藏")
public class CollectController {

    @Resource
    CollectService collectService;

    @ApiOperation(value = "添加收藏")
    @PostMapping(value = "/collect",consumes = "application/json;charset=utf-8")
    public ResultInfo<Boolean> addCollect(@RequestBody Collect collect){
        return collectService.addCollect(collect);
    }

    @ApiOperation("取消收藏")
//    @ApiImplicitParam(name = "collectId",value ="收藏表中的自增id",dataType = "int",paramType = "query")
    @DeleteMapping(value = "/collect",consumes = "application/json;charset=utf-8")
    public ResultInfo<Boolean> deleteCollect(@RequestBody Collect collect){
        return collectService.deleteCollect(collect);
    }

    @ApiOperation("根据用户id查看所有收藏(时间排序)")
    @ApiImplicitParam(name = "userId",value ="用户id",dataType = "int",paramType = "query")
    @GetMapping("/collect")
    public ResultInfo<List<TitleWithUserValue>> getCollectsByUserid(@RequestParam Integer userId){
        return collectService.getCollectsByUserid(userId);
    }

    @ApiOperation("查看用户A  是否已经收藏B文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value ="用户id",dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "titleId",value ="文章id",dataType = "int",paramType = "query")
    })
    @GetMapping("/iscollect")
    public ResultInfo<Boolean> getCollectsByUserid(
            @RequestParam Integer userId,
            @RequestParam Integer titleId){
        return collectService.isCollected(userId,titleId);
    }

}
