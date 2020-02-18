package com.example.GCPDemo.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    public static void main(String[] args) {
        System.out.println(getCurrentDateTimeCST());
    }

    public static String getCurrentDateTimeCST() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Chicago"));
        return dateTimeFormatter.format(zonedDateTime);
    }
}
