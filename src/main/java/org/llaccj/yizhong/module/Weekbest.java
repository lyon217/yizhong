package org.llaccj.yizhong.module;

import java.util.Date;

public class Weekbest {
    private Integer id;

    private Integer type;

    private Integer weeknum;

    private String content;

    private Date time;

    public Weekbest(Integer id, Integer type, Integer weeknum, String content, Date time) {
        this.id = id;
        this.type = type;
        this.weeknum = weeknum;
        this.content = content;
        this.time = time;
    }public Weekbest(Integer type, Integer weeknum, String content) {
        this.type = type;
        this.weeknum = weeknum;
        this.content = content;
    }

    public Weekbest() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getWeeknum() {
        return weeknum;
    }

    public void setWeeknum(Integer weeknum) {
        this.weeknum = weeknum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}