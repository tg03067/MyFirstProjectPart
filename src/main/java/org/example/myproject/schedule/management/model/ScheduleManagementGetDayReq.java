package org.example.myproject.schedule.management.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.example.myproject.common.page.Paging;


@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ScheduleManagementGetDayReq extends Paging {
    private long userSeq;
    @Schema(description = "해당 년월일")
    private String managementDate ;

    public ScheduleManagementGetDayReq(int page, int size) {
        super(page, size);
    }
}
