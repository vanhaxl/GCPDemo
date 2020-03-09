package com.example.GCPDemo.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource("classpath:/${envTarget}/gcp-bigquery-connection.properties")
public class BigQueryConfig {

    @Value("${bigquery.project.name}")
    private String projectName;

    @Value("${bigquery.dataset.name}")
    private String datasetName;

    @Value("${bigquery.table.splunk}")
    private String tableSplunk;

    @Value("${bigquery.table.dynatrace}")
    private String tableDynatrace;

    @Value("${bigquery.table.prometheus}")
    private String tablePrometheus;

}
