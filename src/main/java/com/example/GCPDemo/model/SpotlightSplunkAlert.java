package com.example.GCPDemo.model;

public class SpotlightSplunkAlert {
    private String alertType;
    private String customMessage;
    private String tag;
    private String occurrenceTime;

    public SpotlightSplunkAlert() {

    }

    public SpotlightSplunkAlert(String alertType, String customMessage, String tag, String occurrenceTime) {
        this.alertType = alertType;
        this.customMessage = customMessage;
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

/*

{
    "alertType": "{{event.shortDesc}}",
    "customMessage": "{{event.properties.custom_message}}",
    "tag": "{{event.properties.tag.value}}",
    "occurrenceTime":"{{event.occurenceTime}}"
}
 */
