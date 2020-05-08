package org.llaccj.yizhong.service.gift;

import org.llaccj.yizhong.module.Gift;
import org.llaccj.yizhong.module.GiftLog;
import org.llaccj.yizhong.module.config.ResultInfo;

import java.util.List;

/**
 * @ClassName giftService
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-18 11:25
 * @Version
 **/
public interface GiftService {


    ResultInfo<List<Gift>> getGifts();

    ResultInfo<String> ExchangeGift(GiftLog giftLog);

    ResultInfo<List<GiftLog>> getGiftLog();


    Boolean ReduceGoldNum(int id,int num);

    ResultInfo<List<GiftLog>> getUserGiftlog(Integer id);

    ResultInfo<Boolean> postGift(Gift gift);
}
