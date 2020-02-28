package com.example.GCPDemo.service;

import com.example.GCPDemo.dao.SplunkAlertDAO;
import com.example.GCPDemo.mapper.SplunkAlertMapper;
import com.example.GCPDemo.model.SplunkAlertMessage;
import com.example.GCPDemo.util.ObjectSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SplunkAlertService {

    @Autowired
    private SplunkAlertDAO splunkAlertDAO;

    @Autowired
    private SplunkAlertMapper splunkAlertMapper;

    @Autowired
    ObjectSerializer objectSerializer;

    public void saveAlert(String alertMessage) throws InterruptedException {
        System.out.println(alertMessage);

        SplunkAlertMessage splunkAlertMessage = splunkAlertMapper.mapSplunkAlertMessage(alertMessage);

        System.out.println("REsult:");
        System.out.println(objectSerializer.serializeObject(splunkAlertMessage));

        splunkAlertDAO.saveAlertToDB(splunkAlertMessage);
    }
}
