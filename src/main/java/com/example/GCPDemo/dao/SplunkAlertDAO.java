package com.example.GCPDemo.dao;

import com.example.GCPDemo.constant.AppConstant;
import com.example.GCPDemo.model.SplunkAlertMessage;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.QueryJobConfiguration;
import org.springframework.stereotype.Repository;

@Repository
public class SplunkAlertDAO {

    public void saveAlertToDB(SplunkAlertMessage splunkAlertMessage) throws InterruptedException {
        BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
        String query = String.format(AppConstant.queryInsertSplunkAlertToGCP,
                AppConstant.PROJECT_NAME, AppConstant.DATASET_NAME, AppConstant.TABLE_SPLUNK_ALERT,
                splunkAlertMessage.getAlertType(),
                splunkAlertMessage.getCustomMessage(),
                splunkAlertMessage.getStoreNumber(),
                splunkAlertMessage.getRegisterNumber(),
                splunkAlertMessage.getClientRequestId(),
                splunkAlertMessage.getRequestId(),
                splunkAlertMessage.getRequestRoute(),
                splunkAlertMessage.getResponseBody(),
                splunkAlertMessage.getTag(),
                splunkAlertMessage.getOccurrenceTime());

        QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();
        bigquery.query(queryConfig);
    }
}
