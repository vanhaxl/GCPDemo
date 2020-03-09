package com.example.GCPDemo.dao;

import com.example.GCPDemo.config.BigQueryConfig;
import com.example.GCPDemo.constant.AppConstant;
import com.example.GCPDemo.model.PrometheusAlertMessage;
import com.example.GCPDemo.util.ObjectSerializer;
import com.google.cloud.bigquery.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PrometheusAlertDAO {

    @Autowired
    private ObjectSerializer objectSerializer;

    @Autowired
    private BigQueryConfig bigQueryConfig;

    public void saveAlertToDB(List<PrometheusAlertMessage> prometheusAlertMessages) {
        BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

        List<InsertAllRequest.RowToInsert> rows = new ArrayList<>();
        for (PrometheusAlertMessage prometheusAlertMessage : prometheusAlertMessages) {
            Map<String, Object> map = new HashMap<>();
            map.put("alert_name", prometheusAlertMessage.getAlertName());
            map.put("store_number", prometheusAlertMessage.getStoreNumber());
            map.put("cluster_region", prometheusAlertMessage.getClusterRegion());
            map.put("container", prometheusAlertMessage.getContainer());
            map.put("namespace", prometheusAlertMessage.getNamespace());
            map.put("pod", prometheusAlertMessage.getPod());
            map.put("severity", prometheusAlertMessage.getSeverity());
            map.put("message", prometheusAlertMessage.getMessage());
            map.put("occurrence_time", prometheusAlertMessage.getOccurrenceTime());

            InsertAllRequest.RowToInsert row = InsertAllRequest.RowToInsert.of(map);
            rows.add(row);
        }

        TableId tableId = TableId.of(bigQueryConfig.getProjectName(), bigQueryConfig.getDatasetName(), bigQueryConfig.getTablePrometheus());
        InsertAllRequest insertRequest = InsertAllRequest.newBuilder(tableId, rows).build();
        InsertAllResponse insertResponse = bigquery.insertAll(insertRequest);

        if (insertResponse.hasErrors()) {
            System.out.println("Errors occurred while inserting prometheus alert: " + objectSerializer.serializeObject(prometheusAlertMessages));
        }
    }
}
