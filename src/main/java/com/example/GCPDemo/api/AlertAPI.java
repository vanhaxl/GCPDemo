package com.example.GCPDemo.api;


import com.example.GCPDemo.dao.Model;
import com.example.GCPDemo.model.AlertMessage;
import com.example.GCPDemo.model.SplunkAlertMessage;
import com.example.GCPDemo.model.SpotlightSplunkAlert;
import com.example.GCPDemo.service.AlertService;
import com.example.GCPDemo.service.SplunkAlertService;
import com.example.GCPDemo.util.ObjectSerializer;
import com.sun.scenario.effect.light.SpotLight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AlertAPI {

    @Autowired
    private AlertService alertService;
    @Autowired
    private SplunkAlertService splunkAlertService;

    @Autowired
    private ObjectSerializer objectSerializer;

    @RequestMapping(value = "/alert", method = RequestMethod.POST)
    public ResponseEntity<?> saveAlert(@RequestBody AlertMessage alertMessage) throws InterruptedException {
        System.out.println("Save new alert coming: " + alertMessage.getMessage());
        alertService.saveAlert(alertMessage);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/alert/splunk", method = RequestMethod.POST)
    public ResponseEntity<?> saveAlertSplunk(@RequestBody String alertMessage) throws InterruptedException {
        System.out.println("Save new splunk alert coming: ");
        System.out.println(alertMessage);
        splunkAlertService.saveAlert(alertMessage);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

}
