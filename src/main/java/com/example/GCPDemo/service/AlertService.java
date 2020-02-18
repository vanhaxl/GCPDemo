package com.example.GCPDemo.service;

import com.example.GCPDemo.dao.AlertDAO;
import com.example.GCPDemo.model.AlertMessage;
import com.example.GCPDemo.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertService {

    @Autowired
    private AlertDAO alertDAO;

    public void saveAlert(AlertMessage alertMessage) throws InterruptedException {
        alertMessage.setTime(DateTimeUtil.getCurrentDateTimeCST());
        alertDAO.saveAlertToDB(alertMessage);
    }
}
