package com.example.GCPDemo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DynatraceAlertMessage {

    private String status;

    private String problemId;

    private String problemTitle;

    private String impactedEntity;

    private String storeNumber;

    private List<String> appNames;

    private String occurrenceTime;
}
