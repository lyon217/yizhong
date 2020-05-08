package org.llaccj.yizhong.service.others;

import org.llaccj.yizhong.module.BaseDict;
import org.llaccj.yizhong.module.config.ResultInfo;

import java.util.List;

/**
 * @ClassName BaseDictService
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-20 16:14
 * @Version
 **/
public interface BaseDictService {

    ResultInfo<List<BaseDict>> getCodeTwoFromOne(Integer dictCodeOne);
}
