package com.example.GCPDemo.service;

import com.example.GCPDemo.dao.SplunkAlertDAO;
import com.example.GCPDemo.mapper.SplunkAlertMapper;
import com.example.GCPDemo.model.SplunkAlertMessage;
import com.example.GCPDemo.util.ObjectSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SplunkAlertService {

    @Autowired
    private SplunkAlertDAO splunkAlertDAO;

    @Autowired
    private SplunkAlertMapper splunkAlertMapper;

    @Autowired
    private ObjectSerializer objectSerializer;

    public void saveAlert(String alertMessage) throws InterruptedException {

        SplunkAlertMessage splunkAlertMessage = splunkAlertMapper.mapSplunkAlertMessage(alertMessage);

        log.info("Splunk alert after mapping: {}", objectSerializer.serializeObject(splunkAlertMessage));

        splunkAlertDAO.saveAlertToDB(splunkAlertMessage);
    }
}
