package com.example.GCPDemo.service;

import com.example.GCPDemo.dao.PrometheusAlertDAO;
import com.example.GCPDemo.dao.SplunkAlertDAO;
import com.example.GCPDemo.mapper.PrometheusAlertMapper;
import com.example.GCPDemo.mapper.SplunkAlertMapper;
import com.example.GCPDemo.model.PrometheusAlertMessage;
import com.example.GCPDemo.model.SplunkAlertMessage;
import com.example.GCPDemo.util.ObjectSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrometheusAlertService {

    @Autowired
    private PrometheusAlertDAO prometheusAlertDAO;

    @Autowired
    private PrometheusAlertMapper prometheusAlertMapper;

    @Autowired
    ObjectSerializer objectSerializer;

    public void saveAlert(String alertMessage) throws InterruptedException {
        List<PrometheusAlertMessage> prometheusAlertMessages = prometheusAlertMapper.mapPrometheusAlertMessage(alertMessage);

        System.out.println("REsult:");
        System.out.println(objectSerializer.serializeObject(prometheusAlertMessages));

        prometheusAlertDAO.saveAlertToDB(prometheusAlertMessages);
    }
}
