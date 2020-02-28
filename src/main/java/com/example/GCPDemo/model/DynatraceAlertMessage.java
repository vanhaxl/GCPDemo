package com.example.GCPDemo.model;

import java.util.List;

public class DynatraceAlertMessage {

    private String status;
    private String problemId;
    private String problemTitle;
    private String impactedEntity;
    private String storeNumber;
    private List<String> appNames;
    private String occurrenceTime;


    public DynatraceAlertMessage(){

    }

    public DynatraceAlertMessage(String status, String problemId, String problemTitle, String impactedEntity, String storeNumber, List<String> appNames, String occurrenceTime) {
        this.status = status;
        this.problemId = problemId;
        this.problemTitle = problemTitle;
        this.impactedEntity = impactedEntity;
        this.storeNumber = storeNumber;
        this.appNames = appNames;
        this.occurrenceTime = occurrenceTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProblemId() {
        return problemId;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }

    public String getProblemTitle() {
        return problemTitle;
    }

    public void setProblemTitle(String problemTitle) {
        this.problemTitle = problemTitle;
    }

    public String getImpactedEntity() {
        return impactedEntity;
    }

    public void setImpactedEntity(String impactedEntity) {
        this.impactedEntity = impactedEntity;
    }

    public String getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }

    public List<String> getAppNames() {
        return appNames;
    }

    public void setAppNames(List<String> appNames) {
        this.appNames = appNames;
    }

    public String getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(String occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }
}
