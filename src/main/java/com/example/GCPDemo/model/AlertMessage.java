package com.example.GCPDemo.model;

public class AlertMessage {
    private int code;
    private String message;
    private String store;
    private String market;
    private String country;

    private String time;

    public AlertMessage() {

    }

    public AlertMessage(int code, String message, String store, String market, String country, String time) {
        this.code = code;
        this.message = message;
        this.store = store;
        this.market = market;
        this.country = country;
        this.time = time;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
