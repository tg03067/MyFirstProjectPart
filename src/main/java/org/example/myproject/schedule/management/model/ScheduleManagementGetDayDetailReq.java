package org.example.myproject.schedule.management.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.example.myproject.common.page.Paging;

@Getter
@Setter
public class ScheduleManagementGetDayDetailReq extends Paging {
    private String plantManagementSeq;
    @Schema(description = "해당 년월일")
    private String managementDate;

    public ScheduleManagementGetDayDetailReq(Integer page, Integer size) {
        super(page, size);
    }
}