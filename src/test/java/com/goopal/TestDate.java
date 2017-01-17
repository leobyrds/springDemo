package com.goopal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * @author: 飞鸟 (feiniao@51huxin.com)
 * @createDate: 2016/12/13
 * @company: (C) Copyright 阳光互信 2016
 * @since: JDK 1.8
 * @description:
 */
public class TestDate {
    public static void main(String[] args) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date date = df.parse("20161213");
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 18);

        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        System.out.println(df.format(calendar.getTime()));

    }
}
