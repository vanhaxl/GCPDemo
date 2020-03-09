package com.example.GCPDemo.constant;

import java.util.Arrays;
import java.util.List;

public class AppConstant {

    public static final String queryInsertAlertToGCP = "insert into `%s`.%s.%s (code, message, store, market, country, time) values (%d, \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")";

    public static final String queryInsertSplunkAlertToGCP = "insert into `%s`.%s.%s (alert_type, custom_message, store_number, register_number, client_request_id, request_id, request_route, response_body, tag, occurrence_time)" +
            " values (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")";

    public static final String queryInsertPrometheusAlertToGCP = "insert into `%s`.%s.%s (alert_name, store_number, cluster_region, container, namespace, pod, severity, message, occurrence_time) " +
            "values (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")";

    public static final String queryInsertDynatraceAlertToGCP = "insert into `%s`.%s.%s (status, problem_id, problem_title, impacted_entity, store_number, app_names, occurrence_time) " +
            "values (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")";

    public static final String PROJECT_NAME = "wmt-ct-insights-dev";
    //public static final String PROJECT_NAME = "valiant-guild-268220";

    public static final String DATASET_NAME = "SRT_Alerts";
    //public static final String DATASET_NAME = "mydataset";

    public static final String TABLE_SPLUNK_ALERT = "splunk_alert";

    public static final String TABLE_DYNATRACE_ALERT = "dynatrace_alert";

    public static final String TABLE_PROMETHEUS_ALERT = "prometheus_alert";


    public static final List<String> appNames = Arrays.asList(
            "cpc-bin-service", "cpc-cart-app", "cpc-checkout-app",
            "cpc-oper-auth", "cpc-order-management", "cpc-payment-auth",
            "cpc-tc-service", "girservice", "posoe", "receipt-service-app",
            "secrets-manager-cpc", "tiller-deploy", "wmtwebpos"
    );


}
