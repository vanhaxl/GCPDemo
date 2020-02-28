package com.example.GCPDemo.mapper;

import com.example.GCPDemo.model.CustomMessage;
import com.example.GCPDemo.model.SplunkAlertMessage;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Component
public class SplunkAlertMapper {

    public SplunkAlertMessage mapSplunkAlertMessage(String alertMessage) {
        String[] arr = alertMessage.split("\\|");

        SplunkAlertMessage splunkAlertMessage = new SplunkAlertMessage();
        splunkAlertMessage.setAlertType(arr[0]);
        splunkAlertMessage.setTag(arr[1]);
        splunkAlertMessage.setOccurrenceTime(mapInstantToZoneDateTime(arr[2]));

        CustomMessage customMessage = mapCustomMessage(arr[3]);
        splunkAlertMessage.setStoreNumber(customMessage.getStoreNumber());
        splunkAlertMessage.setRegisterNumber(customMessage.getRegisterNumber());
        splunkAlertMessage.setClientRequestId(customMessage.getClientRequestId());
        splunkAlertMessage.setRequestId(customMessage.getRequestId());
        splunkAlertMessage.setRequestRoute(customMessage.getRequestRoute());
        splunkAlertMessage.setResponseBody(customMessage.getResponseBody());
        splunkAlertMessage.setCustomMessage(customMessage.getFullMessage());

        return splunkAlertMessage;
    }

    public CustomMessage mapCustomMessage(String s) {
        CustomMessage customMessage = new CustomMessage();
        if (s.startsWith("Cluster ID")) {
            String[] arr = s.split("&#10;");
            Map<String, String> map = new HashMap<>();
            for (String line : arr) {
                if (line.startsWith("ResponseBody")) {
                    int idx = line.indexOf(':');
                    String key = line.substring(0, idx);
                    String val = line.substring(idx + 1);
                    val = val.replace("\\&quot;", "").replace("&quot;", "");
                    map.put(key, val);
                } else {
                    String[] pair = line.split(":");
                    map.put(pair[0], pair[1].trim());
                }
            }
            customMessage.setStoreNumber(map.get("Cluster ID"));
            customMessage.setRegisterNumber(map.get("Register Number"));
            customMessage.setClientRequestId(map.get("Client Request ID"));
            customMessage.setRequestId(map.get("Request ID"));
            customMessage.setRequestRoute(map.get("Request Route"));
            customMessage.setResponseBody(map.get("ResponseBody"));
        } else {
            s = s.replaceAll("&#10;", "").replaceAll("&#39;", "");
            String storeNumber = "Store Number:";
            int idx = s.indexOf(storeNumber);
            customMessage.setStoreNumber(s.substring(idx + storeNumber.length()).replaceAll(" ", ""));
            customMessage.setFullMessage(s);
        }

        return customMessage;
    }

    private String mapInstantToZoneDateTime(String s) {
        Instant instant = Instant.ofEpochMilli(Long.parseLong(s));
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("UTC"));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        return dateTimeFormatter.format(zonedDateTime) + " UTC";
    }
}
