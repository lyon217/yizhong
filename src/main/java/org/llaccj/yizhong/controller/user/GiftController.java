package org.llaccj.yizhong.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.llaccj.yizhong.module.Gift;
import org.llaccj.yizhong.module.GiftLog;
import org.llaccj.yizhong.module.config.ResultInfo;
import org.llaccj.yizhong.service.gift.GiftService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName GiftController
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-18 11:17
 * @Version
 **/
@RestController
@Api(tags = "用户查询礼物,兑换礼物,  管理员查询兑换记录接口")
public class GiftController {
    @Resource
    GiftService giftService;

    @GetMapping("/gift")
    @ApiOperation(value = "用户获取gift列表(无参数)")
    public ResultInfo<List<Gift>> getGiftList(){
        return giftService.getGifts();
    }

    @PostMapping("/giftex")
    @ApiOperation(value = "用户兑换礼物, ")
    public ResultInfo<String> ExchangeGift(@RequestBody GiftLog giftLog){
        return giftService.ExchangeGift(giftLog);
    }

    @GetMapping("/giftlog")
    @ApiOperation(value = "管理员获取所有用户兑换记录(无参数)----按照时间排序")
    public ResultInfo<List<GiftLog>> getGifts(){
        return giftService.getGiftLog();
    }

    @GetMapping("/usergiftlog")
    @ApiOperation(value = "用户获取所有用户兑换记录 按照时间排序")
    @ApiImplicitParam(name = "id",value = "用户id",paramType = "query",dataType = "int")
    public ResultInfo<List<GiftLog>> getUserGiftLog(@RequestParam Integer id){
        return giftService.getUserGiftlog(id);
    }

    @ApiOperation("管理员发布帖子")
    @PostMapping("/gift")
    public ResultInfo<Boolean> postGift(@RequestBody Gift gift){
        return giftService.postGift(gift);
    }

}
