package org.llaccj.yizhong.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DateUtils
 * @Description TODO
 * @Author Lyon
 * @Date 2020-05-06 19:52
 * @Version
 **/
public class DateUtils {
    public static Integer getWeekNum(){
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);//设置周一为一周的第一天
        cal.setTime(date);
        int num = cal.get(Calendar.WEEK_OF_YEAR);
        return num;
    }
}
