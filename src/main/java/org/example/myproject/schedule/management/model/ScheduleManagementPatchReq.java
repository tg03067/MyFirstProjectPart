package org.example.myproject.schedule.management.model;

import lombok.Data;

@Data
public class ScheduleManagementPatchReq {
    private long plantSeq;
    private long plantManagementSeq;
    private int gardening;
    private String contents;
}