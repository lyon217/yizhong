package org.llaccj.yizhong.service.others;

import org.llaccj.yizhong.module.MainPic;
import org.llaccj.yizhong.module.config.ResultInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MainPicService
 * @Description TODO
 * @Author Lyon
 * @Date 2020-05-01 22:37
 * @Version
 **/
@Service
public interface MainPicService{

    ResultInfo<Boolean> addMainPic(MainPic mainPic);

    ResultInfo<Boolean> deleteMainpic(Integer id);

    ResultInfo<List<MainPic>> getMainpic();
}
