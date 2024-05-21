package com.example.huibanbackend.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class dateUtils {

    public static Date stringToDate(String format, String dateString) throws ParseException {
        // format: yyyy-MM-dd or yyyy-MM-dd HH:mm:ss
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date myDate = dateFormat.parse(dateString);
        return myDate;
    }

    public static LocalDate dateToLocalDate(Date date){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        return localDate;
    }

    public static Date localDateToDate(LocalDate localDate){
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        Date date = Date.from(zdt.toInstant());
        return date;
    }

}
