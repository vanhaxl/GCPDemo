package com.example.GCPDemo.service;

import com.example.GCPDemo.dao.DynatraceAlertDAO;
import com.example.GCPDemo.dao.SplunkAlertDAO;
import com.example.GCPDemo.mapper.DynatraceAlertMapper;
import com.example.GCPDemo.mapper.SplunkAlertMapper;
import com.example.GCPDemo.model.DynatraceAlertMessage;
import com.example.GCPDemo.model.SplunkAlertMessage;
import com.example.GCPDemo.util.ObjectSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DynatraceAlertService {

    @Autowired
    private DynatraceAlertDAO dynatraceAlertDAO;

    @Autowired
    private DynatraceAlertMapper dynatraceAlertMapper;

    @Autowired
    ObjectSerializer objectSerializer;

    public void saveAlert(String alertMessage) throws InterruptedException {
        System.out.println(alertMessage);

        DynatraceAlertMessage dynatraceAlertMessage = dynatraceAlertMapper.mapDynatraceAlertMessage(alertMessage);

        System.out.println("Result:");
        System.out.println(objectSerializer.serializeObject(dynatraceAlertMessage));

        dynatraceAlertDAO.saveAlertToDB(dynatraceAlertMessage);
    }
}
