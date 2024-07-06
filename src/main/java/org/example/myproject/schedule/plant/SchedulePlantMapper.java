package org.example.myproject.schedule.plant;

import org.apache.ibatis.annotations.Mapper;
import org.example.myproject.schedule.plant.model.*;

import java.util.List;


@Mapper
public interface SchedulePlantMapper {
    int insSchedule(SchedulePlantPostReq p);
    int updateSchedule(SchedulePlantPatchReq p);
    int deleteSchedule(SchedulePlantDeleteReq p);
    List<SchedulePlantGetListRes> getSchedulePlantsList(SchedulePlantGetListReq p);
    SchedulePlantGetDetailRes getSchedulePlantDetail(SchedulePlantGetDetailReq p);

    Integer findPageInfo(SchedulePlantGetListReq p);
    int getTotal(SchedulePlantGetListReq p);
}
