package org.llaccj.yizhong.service.others;

import org.llaccj.yizhong.module.MainPic;
import org.llaccj.yizhong.module.config.ResultInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName MainPicServiceImpl
 * @Description TODO
 * @Author Lyon
 * @Date 2020-05-01 22:37
 * @Version
 **/
@Service
public class MainPicServiceImpl implements MainPicService {

    @Resource
    MainPicMapper mainPicMapper;

    @Override
    public ResultInfo<Boolean> addMainPic(MainPic mainPic) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();

        Boolean b = mainPicMapper.insertSelective(mainPic);

        resultInfo.setSuccess(b);
        resultInfo.setData(b);
        return resultInfo;
    }

    @Override
    public ResultInfo<Boolean> deleteMainpic(Integer id) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();
        Boolean b = mainPicMapper.deleteByPrimaryKey(id);

        resultInfo.setSuccess(b);
        resultInfo.setData(b);
        return resultInfo;
    }

    @Override
    public ResultInfo<List<MainPic>> getMainpic() {
        ResultInfo<List<MainPic>> resultInfo = new ResultInfo<>();
        List<MainPic> mainPics = mainPicMapper.getAll();

        resultInfo.setSuccess(true);
        resultInfo.setData(mainPics);
        return resultInfo;
    }
}
