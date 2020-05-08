package org.llaccj.yizhong.service.gift;

import org.llaccj.yizhong.module.Gift;
import org.llaccj.yizhong.module.GiftLog;
import org.llaccj.yizhong.module.config.ResultInfo;
import org.llaccj.yizhong.service.user.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GiftServiceImpl
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-18 11:26
 * @Version
 **/
@Service
public class GiftServiceImpl implements GiftService {

    @Resource
    GiftMapper giftMapper;
    @Resource
    GiftLogMapper giftLogMapper;
    @Resource
    UserMapper userMapper;


    @Override
    public ResultInfo<List<Gift>> getGifts() {
        List<Gift> gifts = giftMapper.getGifts();
        ArrayList<Gift> a = new ArrayList<>();
        a.addAll(gifts);

        ResultInfo<List<Gift>> resultInfo = new ResultInfo<>();

        resultInfo.setSuccess(true);
        resultInfo.setData(a);

        return resultInfo;
    }

    @Override
    public ResultInfo<String> ExchangeGift(GiftLog giftLog) {
        ResultInfo<String> resultInfo = new ResultInfo<>();

        int i = userMapper.selectUserStatus(giftLog.getUserid());
        if (i == 0) {
            resultInfo.setMessage("用户已被禁止");
            resultInfo.setSuccess(false);
            return resultInfo;
        }


        int goldNum = userMapper.selectGoldNum(giftLog.getUserid());
        int giftGoldnum = giftMapper.selectGiftGoldNum(giftLog.getGiftid());
        if (goldNum > giftGoldnum) {
            Boolean b = giftLogMapper.insertSelective(giftLog);
            resultInfo.setSuccess(b);
            resultInfo.setMessage("兑换成功");
            return resultInfo;
        } else {
            resultInfo.setMessage("金币数不够,无法兑换");
            resultInfo.setSuccess(false);
            return resultInfo;
        }
    }

    @Override
    public ResultInfo<List<GiftLog>> getGiftLog() {
        List<GiftLog> giftLogs = giftLogMapper.getgiflog();

        ArrayList<GiftLog> a = new ArrayList<>();
        ResultInfo<List<GiftLog>> resultInfo = new ResultInfo<>();

        a.addAll(giftLogs);
        resultInfo.setSuccess(true);
        resultInfo.setData(a);
        resultInfo.setMessage("兑换成功");
        return resultInfo;
    }


    @Override
    public Boolean ReduceGoldNum(int id, int num) {
        Boolean b = userMapper.reduceGoldNum(id, num);
        return b;
    }

    @Override
    public ResultInfo<List<GiftLog>> getUserGiftlog(Integer id) {
        ResultInfo<List<GiftLog>> resultInfo = new ResultInfo<>();

        List<GiftLog> giftLogs = giftLogMapper.selectUserGiftLog(id);
        resultInfo.setMessage("兑换记录" + giftLogs.size() + "条");
        resultInfo.setSuccess(true);
        resultInfo.setData(giftLogs);
        return resultInfo;
    }

    @Override
    public ResultInfo<Boolean> postGift(Gift gift) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();

        Boolean aBoolean = giftMapper.insertSelective(gift);

        resultInfo.setSuccess(aBoolean);
        resultInfo.setMessage("发布成功");
        return resultInfo;
    }

}
