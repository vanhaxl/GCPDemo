package com.example.GCPDemo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SplunkAlertMessage {

    private String alertType;

    private String customMessage;

    private String storeNumber;

    private String registerNumber;

    private String clientRequestId;

    private String requestId;

    private String requestRoute;

    private String responseBody;

    private String tag;

    private String occurrenceTime;

}
