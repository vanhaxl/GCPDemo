package com.example.GCPDemo.api;


import com.example.GCPDemo.service.DynatraceAlertService;
import com.example.GCPDemo.service.PrometheusAlertService;
import com.example.GCPDemo.service.SplunkAlertService;
import com.example.GCPDemo.util.ObjectSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AlertAPI {

    @Autowired
    private SplunkAlertService splunkAlertService;

    @Autowired
    private PrometheusAlertService prometheusAlertService;

    @Autowired
    private DynatraceAlertService dynatraceAlertService;

    @Autowired
    private ObjectSerializer objectSerializer;

    @RequestMapping(value = "/alert/splunk", method = RequestMethod.POST)
    public ResponseEntity<?> saveAlertSplunk(@RequestBody String alertMessage) throws InterruptedException {
        log.info("Start - Save splunk alert: {}", objectSerializer.serializeObject(alertMessage));
        splunkAlertService.saveAlert(alertMessage);
        log.info("End - Save splunk alert: {}", objectSerializer.serializeObject(alertMessage));
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/alert/dynatrace", method = RequestMethod.POST)
    public ResponseEntity<?> saveAlertDynatrace(@RequestBody String alertMessage) throws InterruptedException {
        log.info("Start - Save dynatrace alert: {}", objectSerializer.serializeObject(alertMessage));
        dynatraceAlertService.saveAlert(alertMessage);
        log.info("End - Save dynatrace alert: {}", objectSerializer.serializeObject(alertMessage));
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/alert/prometheus", method = RequestMethod.POST)
    public ResponseEntity<?> saveAlertPrometheus(@RequestBody String alertMessage) throws InterruptedException {
        log.info("Start - Save prometheus alert: {}", objectSerializer.serializeObject(alertMessage));
        prometheusAlertService.saveAlert(alertMessage);
        log.info("End - Save prometheus alert: {}", objectSerializer.serializeObject(alertMessage));
        return ResponseEntity.ok(HttpStatus.CREATED);
    }



}
