package org.example.myproject.schedule.plant.model;

import lombok.Data;

@Data
public class SchedulePlantPatchReq {
    private long userSeq;
    private long plantSeq;
    private String plantNickName;
    private String etc;
}
