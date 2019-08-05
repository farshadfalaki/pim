package com.farshad.aggregator.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static Date getBeginningMomentOfDay(Date date){
        Calendar calendar = Calendar.getInstance();
        if(date!=null) {
            calendar.setTime(date);
        }
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        return calendar.getTime();
    }
}
