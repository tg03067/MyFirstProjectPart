package org.example.myproject.schedule.management;

import org.apache.ibatis.annotations.Mapper;
import org.example.myproject.schedule.management.model.*;
import org.example.myproject.schedule.management.model.ScheduleManagementPatchReq;

import java.util.List;

@Mapper
public interface ScheduleManagementMapper {
    int insScheduleManagement(ScheduleManagementPostReq p);
    int delScheduleManagement(ScheduleManagementDeleteReq p);
    int updateScheduleManagement(ScheduleManagementPatchReq p);
    List<ScheduleManagementGetMonthRes> selScheduleManagementMonth(ScheduleManagementGetMonthReq p);
    List<ScheduleManagementGetDayRes> selScheduleManagementDay(ScheduleManagementGetDayReq p);
    ScheduleManagementGetDayDetailRes selScheduleManagementDetail(ScheduleManagementGetDayDetailReq p);
    Integer findPageInfo(long p);
    int getTotalElement(ScheduleManagementGetDayReq p);
}
