package org.llaccj.yizhong.controller.others;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.llaccj.yizhong.module.BaseDict;
import org.llaccj.yizhong.module.config.ResultInfo;
import org.llaccj.yizhong.service.others.BaseDictService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName DictController
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-20 16:04
 * @Version
 **/
@Api(tags = {"根据一级标题获取其下所有二级标题"})
@RestController
public class DictController {

    @Resource
    BaseDictService baseDictService;

    @GetMapping("/basedict")
    @ApiImplicitParam(name = "dictCodeOne",value = "dictCodeOne",paramType = "query",dataType = "int")
    public ResultInfo<List<BaseDict>> getDictList(@RequestParam Integer dictCodeOne){
        return baseDictService.getCodeTwoFromOne(dictCodeOne);

    }


}
