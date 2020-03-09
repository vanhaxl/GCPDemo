package com.example.GCPDemo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrometheusAlertMessage {

    private String alertName;

    private String storeNumber;

    private String clusterRegion;

    private String container;

    private String namespace;

    private String pod;

    private String severity;
    
    private String message;

    private String occurrenceTime;

}
