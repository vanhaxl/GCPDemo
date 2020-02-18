package com.example.GCPDemo.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloGCP {

    @GetMapping("/hello")
    public String hello(){
        return "hello GCP";
    }


}
