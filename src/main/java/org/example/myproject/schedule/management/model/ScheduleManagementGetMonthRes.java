package org.example.myproject.schedule.management.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ScheduleManagementGetMonthRes {
    private int gardening;
    @Schema(description = "해당 월")
    private String managementDate;
}
