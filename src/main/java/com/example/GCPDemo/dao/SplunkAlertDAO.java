package com.example.GCPDemo.dao;

import com.example.GCPDemo.config.BigQueryConfig;
import com.example.GCPDemo.constant.AppConstant;
import com.example.GCPDemo.model.SplunkAlertMessage;
import com.example.GCPDemo.util.ObjectSerializer;
import com.google.cloud.bigquery.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SplunkAlertDAO {

    @Autowired
    private ObjectSerializer objectSerializer;

    @Autowired
    private BigQueryConfig bigQueryConfig;

    public void saveAlertToDB(SplunkAlertMessage splunkAlertMessage) throws InterruptedException {
        BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

        Map<String, Object> row = new HashMap<>();
        row.put("alert_type", splunkAlertMessage.getAlertType());
        row.put("custom_message", splunkAlertMessage.getCustomMessage());
        row.put("store_number", splunkAlertMessage.getStoreNumber());
        row.put("register_number", splunkAlertMessage.getRegisterNumber());
        row.put("client_request_id", splunkAlertMessage.getClientRequestId());
        row.put("request_id", splunkAlertMessage.getRequestId());
        row.put("request_route", splunkAlertMessage.getRequestRoute());
        row.put("response_body", splunkAlertMessage.getResponseBody());
        row.put("tag", splunkAlertMessage.getTag());
        row.put("occurrence_time", splunkAlertMessage.getOccurrenceTime());

        TableId tableId = TableId.of(bigQueryConfig.getProjectName(), bigQueryConfig.getDatasetName(), bigQueryConfig.getTableSplunk());
        InsertAllRequest insertRequest = InsertAllRequest.newBuilder(tableId).addRow(row).build();
        InsertAllResponse insertResponse = bigquery.insertAll(insertRequest);

        if (insertResponse.hasErrors()) {
            System.out.println("Errors occurred while inserting splunk alert: " + objectSerializer.serializeObject(splunkAlertMessage));
        }
    }
}
