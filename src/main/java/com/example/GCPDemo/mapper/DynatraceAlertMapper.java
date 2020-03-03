package com.example.GCPDemo.mapper;

import com.example.GCPDemo.constant.AppConstant;
import com.example.GCPDemo.model.DynatraceAlertMessage;
import com.example.GCPDemo.util.DateTimeUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DynatraceAlertMapper {


    public DynatraceAlertMessage mapDynatraceAlertMessage(String alertMessage) {
        String[] arr = alertMessage.split("\\|");

        DynatraceAlertMessage dynatraceAlertMessage = new DynatraceAlertMessage();
        dynatraceAlertMessage.setStatus(arr[0]);
        dynatraceAlertMessage.setProblemId(arr[1]);
        dynatraceAlertMessage.setProblemTitle(arr[2]);
        dynatraceAlertMessage.setImpactedEntity(arr[3]);
        dynatraceAlertMessage.setStoreNumber(getStoreNumber(arr[4]));
        dynatraceAlertMessage.setAppNames(getAppNames(arr[4]));
        dynatraceAlertMessage.setOccurrenceTime(DateTimeUtil.mapInstantToZoneDateTime(arr[5]));

        return dynatraceAlertMessage;
    }

    private String getStoreNumber(String tag) {
        String[] arr = tag.split(",");
        for (String s : arr) {
            s = s.trim();
            if (s.startsWith("StoreID") || s.startsWith("ClusterId")) {
                String[] tmp = s.split(":");
                if (tmp.length < 2) continue;
                return mapClusterIdToStoreNumber(tmp[1]);
            }
        }
        return null;
    }

    private List<String> getAppNames(String tag) {
        List<String> res = new ArrayList<>();
        String[] arr = tag.split(",");
        for (String s : arr) {
            s = s.trim();
            if (s.startsWith("PodName") || s.startsWith("ContainerName")) {
                String[] tmp = s.split(":");
                if (tmp.length < 2) continue;
                for(String appName: AppConstant.appNames){
                    if(tmp[1].startsWith(appName)){
                        res.add(appName);
                        break;
                    }
                }
            }
        }
        return res;
    }

    private String mapClusterIdToStoreNumber(String s) {
        if (s == null || s.isEmpty()) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString().replaceAll("^0+", "");
    }


}
