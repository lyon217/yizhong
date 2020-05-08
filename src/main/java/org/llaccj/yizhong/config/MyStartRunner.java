//package org.llaccj.yizhong.config;
//
//import org.llaccj.yizhong.module.BaseDict;
//import org.llaccj.yizhong.module.Postss;
//import org.llaccj.yizhong.module.Title;
//import org.llaccj.yizhong.service.PostssMapper;
//import org.llaccj.yizhong.service.others.BaseDictMapper;
//import org.llaccj.yizhong.service.title.TitleMapper;
//import org.llaccj.yizhong.utils.IPUtils;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.List;
//
///**
// * @ClassName MyStartRunner
// * @Description TODO
// * @Author Lyon
// * @Date 2020-04-30 22:02
// * @Version
// **/
//@Service
//
//public class MyStartRunner implements ApplicationRunner {
//
//    @Resource
//    PostssMapper postssMapper;
//    @Resource
//    TitleMapper titleMapper;
//    @Resource
//    BaseDictMapper baseDictMapper;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        HashMap<String, Integer> mapone = new HashMap<>();
//        HashMap<String, Integer> maptwo = new HashMap<>();
//
//        List<BaseDict> baseDicts = baseDictMapper.selectAll();
//
//        for (int i = 1; i < 67; i++) {
//            BaseDict baseDict = baseDicts.get(i);
//            mapone.put(baseDict.getDictType1Name(), baseDict.getDictCodeOne());
//            maptwo.put(baseDict.getDictType2Name(), baseDict.getDictCodeTwo());
//
//        }
//
////        System.out.println(mapone.toString());
////
////        Postss p = postssMapper.selectByPrimaryKey(4);
////        System.out.println(mapone.get("母婴用品"));
////        System.out.println(p.getClassOne());
////
////        System.out.println(mapone.get(p.getClassOne()));
//
//
//
//
//        for (int i = 5; i < 1033; i++) {
//            Title t = new Title();
//            Postss p = postssMapper.selectByPrimaryKey(i);
//
//            t.setTitlename(p.getTitle());
//            t.setAuthorname(p.getAuthor());
//            t.setAuthorid((int) (Math.random() * 100));
//            t.setPicurl(p.getPictureUrl());
//            t.setPosttime(p.getReleaeTime());
//            t.setCodeone(mapone.get(p.getClassOne()));
//            t.setCodetwo(maptwo.get(p.getClassTwo()));
//            t.setLikenum(p.getWorthyNum());
//            t.setUnlikenum(p.getUnworthyNum());
//            t.setCollectnum(p.getCollectNum());
//            t.setIp(IPUtils.getRandomIp());
//            t.setContent(p.getContent());
//
//            titleMapper.insertSelective(t);
////            postssMapper.deleteByPrimaryKey(p.getId());
//
//
//        }
//    }
//
//
////    @Override
////    public void run(ApplicationArguments args) throws Exception {
////
////        for (int i = 100; i < 1038; i++) {
////            Title t = new Title();
////            Postss p = postssMapper.selectByPrimaryKey(i);
////
////            t.setTitlename(p.getTitle());
////            t.setAuthorname(p.getAuthor());
////            t.setAuthorid((int) (Math.random() * 900 + 100));
////            t.setPicurl(p.getPictureUrl());
////            t.setPosttime(p.getReleaeTime());
////            t.setCodeone((int) (Math.random()*100));
////            t.setCodetwo((int) (Math.random()*100));
////            t.setLikenum(p.getWorthyNum());
////            t.setUnlikenum(p.getUnworthyNum());
////            t.setCollectnum(p.getCollectNum());
////            t.setIp(IPUtils.getRandomIp());
////            t.setContent(p.getContent());
////
////            titleMapper.insertSelective(t);
////            postssMapper.deleteByPrimaryKey(p.getId());
////        }
////    }
//}
