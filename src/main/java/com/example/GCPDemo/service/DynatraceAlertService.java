package com.example.GCPDemo.service;

import com.example.GCPDemo.dao.DynatraceAlertDAO;
import com.example.GCPDemo.mapper.DynatraceAlertMapper;
import com.example.GCPDemo.model.DynatraceAlertMessage;
import com.example.GCPDemo.util.ObjectSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DynatraceAlertService {

    @Autowired
    private DynatraceAlertDAO dynatraceAlertDAO;

    @Autowired
    private DynatraceAlertMapper dynatraceAlertMapper;

    @Autowired
    private ObjectSerializer objectSerializer;

    public void saveAlert(String alertMessage) throws InterruptedException {

        DynatraceAlertMessage dynatraceAlertMessage = dynatraceAlertMapper.mapDynatraceAlertMessage(alertMessage);

        log.info("Dynatrace alert after mapping: {}", objectSerializer.serializeObject(dynatraceAlertMessage));

        dynatraceAlertDAO.saveAlertToDB(dynatraceAlertMessage);
    }
}
