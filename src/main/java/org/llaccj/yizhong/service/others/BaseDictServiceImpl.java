package org.llaccj.yizhong.service.others;

import org.llaccj.yizhong.module.BaseDict;
import org.llaccj.yizhong.module.config.ResultInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BaseDictServiceImpl
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-20 16:15
 * @Version
 **/
@Service
public class BaseDictServiceImpl implements BaseDictService {
    @Resource
    BaseDictMapper baseDictMapper;

    @Override
    public ResultInfo<List<BaseDict>> getCodeTwoFromOne(Integer dictCodeOne) {
        ResultInfo<List<BaseDict>> resultInfo = new ResultInfo<>();

        List<BaseDict> baseDicts = new ArrayList<>();
        baseDicts = baseDictMapper.getCodeTwoFromOne(dictCodeOne);

        resultInfo.setSuccess(true);
        resultInfo.setData(baseDicts);
        resultInfo.setMessage("共获得"+baseDicts.size()+"条");

        return resultInfo;
    }
}
