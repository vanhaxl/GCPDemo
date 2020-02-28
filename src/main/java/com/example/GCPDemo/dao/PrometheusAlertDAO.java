package com.example.GCPDemo.dao;

import com.example.GCPDemo.constant.AppConstant;
import com.example.GCPDemo.model.AlertMessage;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.QueryJobConfiguration;
import org.springframework.stereotype.Repository;

@Repository
public class PrometheusAlertDAO {

    public void saveAlertToDB(AlertMessage alertMessage) throws InterruptedException {
        BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
        String query = String.format(AppConstant.queryInsertAlertToGCP,
                AppConstant.PROJECT_NAME, AppConstant.DATASET_NAME, AppConstant.TABLE_PROMETHEUS_ALERT,
                alertMessage.getCode(),
                alertMessage.getMessage(), alertMessage.getStore(), alertMessage.getMarket(), alertMessage.getCountry(), alertMessage.getTime());

        QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();
        bigquery.query(queryConfig);
    }
}
