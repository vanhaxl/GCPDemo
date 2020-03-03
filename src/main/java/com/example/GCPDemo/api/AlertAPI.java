package com.example.GCPDemo.api;


import com.example.GCPDemo.model.AlertMessage;
import com.example.GCPDemo.service.AlertService;
import com.example.GCPDemo.service.DynatraceAlertService;
import com.example.GCPDemo.service.PrometheusAlertService;
import com.example.GCPDemo.service.SplunkAlertService;
import com.example.GCPDemo.util.ObjectSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlertAPI {

    @Autowired
    private AlertService alertService;
    @Autowired
    private SplunkAlertService splunkAlertService;

    @Autowired
    private PrometheusAlertService prometheusAlertService;

    @Autowired
    private DynatraceAlertService dynatraceAlertService;

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

    @RequestMapping(value = "/alert/prometheus", method = RequestMethod.POST)
    public ResponseEntity<?> saveAlertPrometheus(@RequestBody String alertMessage) throws InterruptedException {
        System.out.println("Save new prometheus alert coming: ");
        System.out.println(alertMessage);
        prometheusAlertService.saveAlert(alertMessage);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/alert/dynatrace", method = RequestMethod.POST)
    public ResponseEntity<?> saveAlertDynatrace(@RequestBody String alertMessage) throws InterruptedException {
        System.out.println("Save new dynatrace alert coming: ");
        System.out.println(alertMessage);
        dynatraceAlertService.saveAlert(alertMessage);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

}
