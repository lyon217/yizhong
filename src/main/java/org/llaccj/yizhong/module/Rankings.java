package org.llaccj.yizhong.module;

import org.springframework.stereotype.Component;

/**
 * @ClassName Rankings
 * @Description TODO
 * @Author Lyon
 * @Date 2020-05-06 18:05
 * @Version
 **/
@Component
public class Rankings {
    private Integer clickup_id;
    private Integer times;

    public Rankings(Integer clickup_id, Integer times) {
        this.clickup_id = clickup_id;
        this.times = times;
    }

    @Override
    public String toString() {
        return "{" +
                "clickup_id='" + clickup_id + '\'' +
                ", times=" + times +
                '}';
    }

    public Rankings() {
    }

    public Integer getClickup_id() {
        return clickup_id;
    }

    public void setClickup_id(Integer clickup_id) {
        this.clickup_id = clickup_id;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
}
