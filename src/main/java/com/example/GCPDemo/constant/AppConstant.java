package com.example.GCPDemo.constant;

public class AppConstant {

    public static final String queryInsertAlertToGCP = "insert into `%s`.%s.%s (code, message, store, market, country, time) values (%d, \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")";

    public static final String queryInsertSplunkAlertToGCP = "insert into `%s`.%s.%s (alert_type, custom_message, store_number, register_number, client_request_id, request_id, request_route, response_body, tag, occurrence_time)" +
            " values (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")";

    public static final String PROJECT_NAME = "valiant-guild-268220";

    public static final String DATASET_NAME = "mydataset";

    public static final String tableName = "alert";

    public static final String TABLE_SPLUNK_ALERT = "splunk_alert";

    public static final String TABLE_DYNATRACE_ALERT = "dynatrace_alert";

    public static final String TABLE_PROMETHEUS_ALERT = "prometheus_alert";



}
