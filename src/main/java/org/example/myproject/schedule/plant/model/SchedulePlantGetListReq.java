package org.example.myproject.schedule.plant.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.myproject.common.page.Paging;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class SchedulePlantGetListReq extends Paging {
    private long userSeq;

    public SchedulePlantGetListReq(int page, int size, long userSeq) {
        super(page, size);
        this.userSeq = userSeq;
    }
}
