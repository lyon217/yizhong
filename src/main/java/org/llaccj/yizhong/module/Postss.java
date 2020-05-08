package org.llaccj.yizhong.module;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Postss {
    private Integer id;

    private String title;

    private String price;

    private String classOne;

    private String classTwo;

    private String classThree;

    private String pictureUrl;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date releaeTime;

    private String author;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date beginTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

    private Integer worthyNum;

    private Integer unworthyNum;

    private Integer collectNum;

    private String buyUrl;

    private String discountsUrl;

    private String ip;

    private String content;

    public Postss(Integer id, String title, String price, String classOne, String classTwo, String classThree, String pictureUrl, Date releaeTime, String author, Date beginTime, Date endTime, Integer worthyNum, Integer unworthyNum, Integer collectNum, String buyUrl, String discountsUrl, String ip) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.classOne = classOne;
        this.classTwo = classTwo;
        this.classThree = classThree;
        this.pictureUrl = pictureUrl;
        this.releaeTime = releaeTime;
        this.author = author;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.worthyNum = worthyNum;
        this.unworthyNum = unworthyNum;
        this.collectNum = collectNum;
        this.buyUrl = buyUrl;
        this.discountsUrl = discountsUrl;
        this.ip = ip;
    }

    public Postss(Integer id, String title, String price, String classOne, String classTwo, String classThree, String pictureUrl, Date releaeTime, String author, Date beginTime, Date endTime, Integer worthyNum, Integer unworthyNum, Integer collectNum, String buyUrl, String discountsUrl, String ip, String content) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.classOne = classOne;
        this.classTwo = classTwo;
        this.classThree = classThree;
        this.pictureUrl = pictureUrl;
        this.releaeTime = releaeTime;
        this.author = author;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.worthyNum = worthyNum;
        this.unworthyNum = unworthyNum;
        this.collectNum = collectNum;
        this.buyUrl = buyUrl;
        this.discountsUrl = discountsUrl;
        this.ip = ip;
        this.content = content;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", classOne='" + classOne + '\'' +
                ", classTwo='" + classTwo + '\'' +
                ", classThree='" + classThree + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", releaeTime=" + releaeTime +
                ", author='" + author + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", worthyNum=" + worthyNum +
                ", unworthyNum=" + unworthyNum +
                ", collectNum=" + collectNum +
                ", buyUrl='" + buyUrl + '\'' +
                ", discountsUrl='" + discountsUrl + '\'' +
                ", ip='" + ip + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Postss() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getClassOne() {
        return classOne;
    }

    public void setClassOne(String classOne) {
        this.classOne = classOne == null ? null : classOne.trim();
    }

    public String getClassTwo() {
        return classTwo;
    }

    public void setClassTwo(String classTwo) {
        this.classTwo = classTwo == null ? null : classTwo.trim();
    }

    public String getClassThree() {
        return classThree;
    }

    public void setClassThree(String classThree) {
        this.classThree = classThree == null ? null : classThree.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public Date getReleaeTime() {
        return releaeTime;
    }

    public void setReleaeTime(Date releaeTime) {
        this.releaeTime = releaeTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getWorthyNum() {
        return worthyNum;
    }

    public void setWorthyNum(Integer worthyNum) {
        this.worthyNum = worthyNum;
    }

    public Integer getUnworthyNum() {
        return unworthyNum;
    }

    public void setUnworthyNum(Integer unworthyNum) {
        this.unworthyNum = unworthyNum;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public String getBuyUrl() {
        return buyUrl;
    }

    public void setBuyUrl(String buyUrl) {
        this.buyUrl = buyUrl == null ? null : buyUrl.trim();
    }

    public String getDiscountsUrl() {
        return discountsUrl;
    }

    public void setDiscountsUrl(String discountsUrl) {
        this.discountsUrl = discountsUrl == null ? null : discountsUrl.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}