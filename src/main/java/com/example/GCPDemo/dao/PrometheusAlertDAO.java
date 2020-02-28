package com.example.GCPDemo.dao;

import com.example.GCPDemo.constant.AppConstant;
import com.example.GCPDemo.model.PrometheusAlertMessage;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.QueryJobConfiguration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrometheusAlertDAO {

    public void saveAlertToDB(List<PrometheusAlertMessage> prometheusAlertMessages) throws InterruptedException {
        BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
        for (PrometheusAlertMessage prometheusAlertMessage : prometheusAlertMessages) {
            String query = String.format(AppConstant.queryInsertPrometheusAlertToGCP,
                    AppConstant.PROJECT_NAME, AppConstant.DATASET_NAME, AppConstant.TABLE_PROMETHEUS_ALERT,
                    prometheusAlertMessage.getAlertName(),
                    prometheusAlertMessage.getStoreNumber(),
                    prometheusAlertMessage.getClusterRegion(),
                    prometheusAlertMessage.getContainer(),
                    prometheusAlertMessage.getNamespace(),
                    prometheusAlertMessage.getPod(),
                    prometheusAlertMessage.getSeverity(),
                    prometheusAlertMessage.getMessage(),
                    prometheusAlertMessage.getOccurrenceTime());

            QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();
            bigquery.query(queryConfig);
        }
    }
}
