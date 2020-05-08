package org.llaccj.yizhong.controller.title;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.llaccj.yizhong.module.Clickup;
import org.llaccj.yizhong.module.Title;
import org.llaccj.yizhong.module.TitleWithUserValue;
import org.llaccj.yizhong.module.config.ResultInfo;
import org.llaccj.yizhong.service.title.ClickupService;
import org.llaccj.yizhong.service.title.TitleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName TitleController
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-18 21:29
 * @Version
 **/
@RestController
@Api(tags ="文章增删改查")
public class TitleController {

    @Resource
    ClickupService clickupService;
    @Resource
    TitleService titleService;


    @ApiOperation(value = "给文章点赞",notes = "clickupType为0,自增id不需要要,点赞时间不需要")
    @PostMapping("/titlelike")
    public ResultInfo<Boolean> titleClickup(@RequestBody Clickup clickup){
        return clickupService.titleLike(clickup);
    }


    @ApiOperation(value = "给文章点踩",notes = "clickupType为3,自增id不需要要,点赞时间不需要")
    @PostMapping("/titleunlike")
    public ResultInfo<Boolean> titleClickup2(@RequestBody Clickup clickup){
        return clickupService.titleunLike(clickup);
    }


    @ApiOperation(value = "文章发布接口",notes = "发布时间不需要,自增id不需要")
    @PostMapping("/title")
    public ResultInfo<Boolean> titlePost1(@RequestBody Title title){
        return titleService.postTitle(title);
    }

    @ApiOperation(value = "文章发布接口",notes = "发布时间不需要,自增id不需要")
    @PutMapping(value = "/title")
    public ResultInfo<Boolean> titlePost2(@RequestBody Title title){
        return titleService.postTitle(title);
    }

    @ApiOperation(value = "按照id查看文章")
    @GetMapping("/title")
    public ResultInfo<TitleWithUserValue> getTitleByid(@RequestParam Integer titleId){
        return titleService.getTitleByid(titleId);
    }


    @ApiOperation(value = "用户查看其所有文章")
    @GetMapping("/usertitle")
    public ResultInfo<List<TitleWithUserValue>> getTitlesViauserid(@RequestParam Integer userId){
        return titleService.getTitlesViauserid(userId);
    }

    @ApiOperation(value = "用户删除某一文章")
    @DeleteMapping("/title")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid",value = "用户id",dataType = "int"),
            @ApiImplicitParam(name = "titleid",value = "删除的文章id",dataType = "int")
    })
    public ResultInfo<Boolean> deleteTitleByid(@RequestParam Integer userid,@RequestParam Integer titleid)
    {
        return titleService.deleteTitleByid(userid,titleid);
    }

    @ApiOperation("搜索文章")
    @GetMapping("/searchtitle")
    @ApiImplicitParam(name = "titlename",value = "文章名",dataType = "String", paramType = "query")
    public ResultInfo<List<Title>> searchTitle(@RequestParam String titlename){
        return titleService.searchTitle(titlename);
    }

    @ApiOperation("按照类型查看(每页10个)")
    @GetMapping("/titlelist0")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "classone",value = "类别一",dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "classtwo",value = "类别二",dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "page",value = "页数",dataType = "int",paramType = "query")
    })
    public ResultInfo<PageInfo<Title>> getMainPageTitleList0(
            @RequestParam(value = "classone") Integer classone,
            @RequestParam(value = "classtwo") Integer classtwo,
            @RequestParam(value = "page")Integer page){
        PageHelper.startPage(page,10);
        List<Title> list = titleService.getTitleListByclass(classone,classtwo);
        PageInfo<Title> pageInfo = new PageInfo<Title>(list);

        ResultInfo<PageInfo<Title>> resultInfo = new ResultInfo<>();
        resultInfo.setSuccess(true);
        resultInfo.setData(pageInfo);
        return resultInfo;
    }


    @ApiOperation("主页获取默认列表(每页10个,将其顺序打乱)")
    @GetMapping("/titlelist1")
    public ResultInfo<PageInfo<Title>> getMainPageTitleList1(@RequestParam(value = "page") Integer page){
        PageHelper.startPage(page,10);
        List<Title> list = titleService.getTitleListBydefault();
        PageInfo<Title> pageInfo = new PageInfo<Title>(list);

//        ResultInfo<List<Title>> resultInfo = new ResultInfo<>();
        ResultInfo<PageInfo<Title>> resultInfo = new ResultInfo<>();

        resultInfo.setSuccess(true);
//        resultInfo.setData(list);
        resultInfo.setData(pageInfo);
        return resultInfo;
    }

    @ApiOperation("时间排序获取主页列表(按照时间排序,每页10个)")
    @GetMapping("/titlelist2")
    public ResultInfo<PageInfo<Title>> getMainPageTitleList2(@RequestParam(value = "page") Integer page){
        PageHelper.startPage(page,10);
        List<Title> list = titleService.getTitleListBydefault();
        PageInfo<Title> pageInfo = new PageInfo<Title>(list);

//        ResultInfo<List<Title>> resultInfo = new ResultInfo<>();
        ResultInfo<PageInfo<Title>> resultInfo = new ResultInfo<>();
        resultInfo.setSuccess(true);
//        resultInfo.setData(list);
        resultInfo.setData(pageInfo);
        return resultInfo;
    }



}
