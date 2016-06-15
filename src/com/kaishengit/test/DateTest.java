package com.kaishengit.test;

import org.joda.time.DateTime;
import org.junit.Test;

import javax.xml.ws.soap.MTOM;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/6/15.
 */
public class DateTest {

    @Test
    public void dateTest(){
        Date date = new Date();
        System.out.println(date.getTime());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = simpleDateFormat.format(date);
        System.out.println(now);
    }

    @Test
    public void jodaTimeTest(){
        System.out.println(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        DateTime dateTime = DateTime.now();
        dateTime.plusDays(30);
        System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
    }
}
