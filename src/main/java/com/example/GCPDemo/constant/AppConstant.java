package com.example.GCPDemo.constant;

public class AppConstant {

    public static final String queryInsertAlertToGCP = "insert into `%s`.%s.%s (code, message, store, market, country, time) values (%d, \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")";
    public static final String projectName = "valiant-guild-268220";
    public static final String datasetName = "mydataset";
    public static final String tableName = "alert";

}
