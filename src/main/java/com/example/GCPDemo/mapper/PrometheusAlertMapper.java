package com.example.GCPDemo.mapper;

import com.example.GCPDemo.model.PrometheusAlertMessage;
import com.example.GCPDemo.util.DateTimeUtil;
import com.example.GCPDemo.util.ObjectSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PrometheusAlertMapper {

    @Autowired
    ObjectSerializer objectSerializer;

    public List<PrometheusAlertMessage> mapPrometheusAlertMessage(String alertMessage) {
        String[] arr = alertMessage.split("\\|");

        String occurrenceTime = DateTimeUtil.mapInstantToZoneDateTime(arr[1]);

        return mapPrometheusAlertMessage(arr[0], occurrenceTime);
    }

    public List<PrometheusAlertMessage> mapPrometheusAlertMessage(String alertsMessage, String occurrenceTime) {
        List<PrometheusAlertMessage> prometheusAlertMessages = new ArrayList<>();
        String[] alertArray = alertsMessage.split("Labels:&#10;");
        for (String alert : alertArray) {
            if(alert == null || alert.isEmpty()) continue;
            alert = alert.replaceFirst("  - ", "");

            String[] entries = alert.split("&#10;  - ");

            Map<String, String> map = new HashMap<>();

            for (String entry : entries) {
                String[] arr = entry.split("=");
                if(arr.length < 2) continue;
                map.put(arr[0], arr[1]);
            }
            if(map.size() == 0) continue;
            PrometheusAlertMessage prometheusAlertMessage = new PrometheusAlertMessage();
            prometheusAlertMessage.setAlertName(map.get("alertname"));
            prometheusAlertMessage.setStoreNumber(mapClusterIdToStoreNumber(map.get("cluster_id")));
            prometheusAlertMessage.setClusterRegion(map.get("cluster_region"));
            prometheusAlertMessage.setContainer(map.get("container"));
            prometheusAlertMessage.setNamespace(map.get("namespace"));
            prometheusAlertMessage.setPod(map.get("pod"));
            prometheusAlertMessage.setSeverity(map.get("severity").replace("&#10;Annotations:", ""));
            prometheusAlertMessage.setMessage(map.get("message"));
            prometheusAlertMessage.setOccurrenceTime(occurrenceTime);
            prometheusAlertMessages.add(prometheusAlertMessage);
        }
        return prometheusAlertMessages;
    }


    private String mapClusterIdToStoreNumber(String s) {
        if(s == null || s.isEmpty()) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '-') break;
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString().replaceAll("^0+", "");
    }
}
