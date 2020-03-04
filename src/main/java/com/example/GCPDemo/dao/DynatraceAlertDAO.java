package com.example.GCPDemo.dao;

import com.example.GCPDemo.constant.AppConstant;
import com.example.GCPDemo.model.AlertMessage;
import com.example.GCPDemo.model.DynatraceAlertMessage;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.QueryJobConfiguration;
import org.springframework.stereotype.Repository;

@Repository
public class DynatraceAlertDAO {

    public void saveAlertToDB(DynatraceAlertMessage dynatraceAlertMessage) throws InterruptedException {
        BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
        String query = String.format(AppConstant.queryInsertDynatraceAlertToGCP,
                AppConstant.PROJECT_NAME, AppConstant.DATASET_NAME, AppConstant.TABLE_DYNATRACE_ALERT,
                dynatraceAlertMessage.getStatus(),
                dynatraceAlertMessage.getProblemId(),
                dynatraceAlertMessage.getProblemTitle(),
                dynatraceAlertMessage.getImpactedEntity(),
                dynatraceAlertMessage.getStoreNumber(),
                dynatraceAlertMessage.getAppNames(),
                dynatraceAlertMessage.getOccurrenceTime());

        QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();
        bigquery.query(queryConfig);
    }
}
