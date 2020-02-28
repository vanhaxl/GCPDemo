package com.example.GCPDemo.model;

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

    public PrometheusAlertMessage(){

    }

    public PrometheusAlertMessage(String alertName, String storeNumber, String clusterRegion, String container, String namespace, String pod, String severity, String message, String occurrenceTime) {
        this.alertName = alertName;
        this.storeNumber = storeNumber;
        this.clusterRegion = clusterRegion;
        this.container = container;
        this.namespace = namespace;
        this.pod = pod;
        this.severity = severity;
        this.message = message;
        this.occurrenceTime = occurrenceTime;
    }

    public String getAlertName() {
        return alertName;
    }

    public void setAlertName(String alertName) {
        this.alertName = alertName;
    }

    public String getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }

    public String getClusterRegion() {
        return clusterRegion;
    }

    public void setClusterRegion(String clusterRegion) {
        this.clusterRegion = clusterRegion;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(String occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }
}
