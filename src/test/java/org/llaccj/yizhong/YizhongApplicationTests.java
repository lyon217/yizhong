package org.llaccj.yizhong;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@SpringBootTest
class YizhongApplicationTests {

    @Test
    void contextLoads() throws ParseException {
//        String today ="2020-03-14 12:12:12";
//        System.out.println(new Date());
//        SimpleDateFormat s=  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = s.parse(new Date().toString());
//
//        Calendar calendar = Calendar.getInstance();
//
//        calendar.setFirstDayOfWeek(calendar.MONDAY);
//
//        calendar.setTime(date);
//        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
//        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();
//        System.out.println("today:" + today);
//        System.out.println("time:"+ time);
        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println("localDateTime"+localDateTime);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String today ="2020-03-14 12:12:12";
        LocalDateTime localDateTime1 = LocalDateTime.parse(today,dateTimeFormatter);
        System.out.println(localDateTime1.toString());

    }

    @Test
    public void test2(){
//        int count = 10;
//        for (int i = 0; i < count; i++) {
//            String randomIp = IPUtils.getRandomIp();
//            System.err.println(randomIp);
//        }
//        System.out.println(IPUtils.getRandomIp());
//        System.out.println(IPUtils.getRandomIp());
//        System.out.println(IPUtils.getRandomIp());
//        System.out.println(IPUtils.getRandomIp());
//        System.out.println(IPUtils.getRandomIp());

        HashMap<String,Integer> map = new HashMap<>();

        map.put("第一",1);
        map.put("第二",2);
        map.put("第三",3);

        Integer two = map.get("第d");
        System.out.println(two);
    }

    @Test
    public void test3(){
        int a=0;
        Integer b = null;

//        System.out.println(a==b);
//        System.out.println(b.equals(null));
//        System.out.println(b.equals(0));
        System.out.println(a==0);
    }

}
