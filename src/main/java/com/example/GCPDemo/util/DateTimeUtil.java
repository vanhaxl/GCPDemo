package com.example.GCPDemo.util;

import com.example.GCPDemo.constant.AppConstant;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    public static String getCurrentDateTimeCST() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(AppConstant.DATE_TIME_PATTERN);
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of(AppConstant.TIME_ZONE_CST));
        return dateTimeFormatter.format(zonedDateTime);
    }

    public static String mapInstantToZoneDateTime(String s) {
        Instant instant = Instant.ofEpochMilli(Long.parseLong(s));
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of(AppConstant.TIME_ZONE_UTC));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(AppConstant.DATE_TIME_PATTERN);
        return dateTimeFormatter.format(zonedDateTime) + " UTC";
    }
}
