package com.example.GCPDemo.service;

import com.example.GCPDemo.dao.PrometheusAlertDAO;
import com.example.GCPDemo.mapper.PrometheusAlertMapper;
import com.example.GCPDemo.model.PrometheusAlertMessage;
import com.example.GCPDemo.util.ObjectSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PrometheusAlertService {

    @Autowired
    private PrometheusAlertDAO prometheusAlertDAO;

    @Autowired
    private PrometheusAlertMapper prometheusAlertMapper;

    @Autowired
    private ObjectSerializer objectSerializer;

    public void saveAlert(String alertMessage) {

        List<PrometheusAlertMessage> prometheusAlertMessages = prometheusAlertMapper.mapPrometheusAlertMessage(alertMessage);

        log.info("Prometheus alert after mapping: {}", objectSerializer.serializeObject(prometheusAlertMessages));

        prometheusAlertDAO.saveAlertToDB(prometheusAlertMessages);
    }
}
