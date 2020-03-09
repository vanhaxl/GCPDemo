package com.example.GCPDemo.dao;

import com.example.GCPDemo.constant.AppConstant;
import com.example.GCPDemo.model.DynatraceAlertMessage;
import com.example.GCPDemo.util.ObjectSerializer;
import com.google.cloud.bigquery.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DynatraceAlertDAO {

    @Autowired
    private ObjectSerializer objectSerializer;

    public void saveAlertToDB(DynatraceAlertMessage dynatraceAlertMessage) throws InterruptedException {
        BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

        Map<String, Object> row = new HashMap<>();
        row.put("status", dynatraceAlertMessage.getStatus());
        row.put("problem_id", dynatraceAlertMessage.getProblemId());
        row.put("problem_title", dynatraceAlertMessage.getProblemTitle());
        row.put("impacted_entity", dynatraceAlertMessage.getImpactedEntity());
        row.put("store_number", dynatraceAlertMessage.getStoreNumber());
        row.put("app_names", objectSerializer.serializeObject(dynatraceAlertMessage.getAppNames()));
        row.put("occurrence_time", dynatraceAlertMessage.getOccurrenceTime());

        TableId tableId = TableId.of(AppConstant.PROJECT_NAME, AppConstant.DATASET_NAME, AppConstant.TABLE_DYNATRACE_ALERT);
        InsertAllRequest insertRequest = InsertAllRequest.newBuilder(tableId).addRow(row).build();
        InsertAllResponse insertResponse = bigquery.insertAll(insertRequest);

        if (insertResponse.hasErrors()) {
            System.out.println("Errors occurred while inserting dynatrace alert: " + objectSerializer.serializeObject(dynatraceAlertMessage));
        }
    }
}
