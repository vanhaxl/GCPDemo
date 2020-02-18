package com.example.GCPDemo.api;


import com.example.GCPDemo.model.AlertMessage;
import com.example.GCPDemo.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AlertAPI {

    @Autowired
    private AlertService alertService;

    @RequestMapping(value = "/alert", method = RequestMethod.POST)
    public ResponseEntity<?> saveAlert(@RequestBody AlertMessage alertMessage) throws InterruptedException {
        alertService.saveAlert(alertMessage);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
