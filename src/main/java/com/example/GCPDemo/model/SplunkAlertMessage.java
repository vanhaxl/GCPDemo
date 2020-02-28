package com.example.GCPDemo.model;

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

    public SplunkAlertMessage() {

    }

    public SplunkAlertMessage(String alertType, String customMessage, String storeNumber, String registerNumber, String clientRequestId, String requestId, String requestRoute, String responseBody, String tag, String occurrenceTime) {
        this.alertType = alertType;
        this.customMessage = customMessage;
        this.storeNumber = storeNumber;
        this.registerNumber = registerNumber;
        this.clientRequestId = clientRequestId;
        this.requestId = requestId;
        this.requestRoute = requestRoute;
        this.responseBody = responseBody;
        this.tag = tag;
        this.occurrenceTime = occurrenceTime;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }

    public String getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getClientRequestId() {
        return clientRequestId;
    }

    public void setClientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestRoute() {
        return requestRoute;
    }

    public void setRequestRoute(String requestRoute) {
        this.requestRoute = requestRoute;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(String occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }
}
