package org.llaccj.yizhong.controller.others;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.llaccj.yizhong.module.MainPic;
import org.llaccj.yizhong.module.config.ResultInfo;
import org.llaccj.yizhong.service.others.MainPicService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName MainPicContro
 * @Description TODO
 * @Author Lyon
 * @Date 2020-05-01 22:35
 * @Version
 **/
@RestController
@Api(tags = "轮播图增加,删除,修改,查看")
public class MainPicController {

    @Resource
    MainPicService mainPicService;

    @ApiOperation(value = "添加轮播图")
    @PutMapping(value = "/mainpic",consumes = "application/json;charset=utf-8")
    public ResultInfo<Boolean> addMainpic(@RequestBody MainPic mainPic){
        return mainPicService.addMainPic(mainPic);
    }

    @ApiOperation("删除轮播图")
    @ApiImplicitParam(name = "id",value = "删除的轮播图id",dataType = "int")
    @DeleteMapping(value = "/mainpic")
    public ResultInfo<Boolean> deleteMainpic(@RequestParam Integer id){
        return mainPicService.deleteMainpic(id);
    }

    @ApiOperation("查看所有轮播图")
    @GetMapping("/mainpic")
    public ResultInfo<List<MainPic>> getMainpic(){
        return mainPicService.getMainpic();
    }





}
