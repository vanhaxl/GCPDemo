package com.example.GCPDemo.dao;

import com.example.GCPDemo.constant.AppConstant;
import com.example.GCPDemo.model.AlertMessage;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.QueryJobConfiguration;
import org.springframework.stereotype.Repository;

@Repository
public class AlertDAO {

    public void saveAlertToDB(AlertMessage alertMessage) throws InterruptedException {
        BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
        String query = String.format(AppConstant.queryInsertAlertToGCP,
                AppConstant.projectName, AppConstant.datasetName, AppConstant.tableName,
                alertMessage.getCode(),
                alertMessage.getMessage(), alertMessage.getStore(), alertMessage.getMarket(), alertMessage.getCountry(), alertMessage.getTime());

        QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();
        bigquery.query(queryConfig);
    }
}
