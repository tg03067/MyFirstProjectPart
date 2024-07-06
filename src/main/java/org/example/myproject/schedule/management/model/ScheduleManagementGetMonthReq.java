package org.example.myproject.schedule.management.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ScheduleManagementGetMonthReq {
    private long userSeq;
    @Schema(description = "해당 년월일")
    private String managementDate;
}
