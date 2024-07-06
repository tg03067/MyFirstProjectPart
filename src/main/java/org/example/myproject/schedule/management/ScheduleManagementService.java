package org.example.myproject.schedule.management;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.myproject.common.GlobalConst;
import org.example.myproject.common.exception.DataNotFoundException;
import org.example.myproject.common.page.ResponseDTO2;
import org.example.myproject.schedule.management.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduleManagementService {
    private final ScheduleManagementMapper mapper;

    public int insScheduleManagement(ScheduleManagementPostReq p) throws Exception {
        int result = mapper.insScheduleManagement(p);
        if(result == 0) throw new DataNotFoundException();
        return result;
    }

    public int delScheduleManagement(ScheduleManagementDeleteReq p) throws Exception {
        int deleteResult = mapper.delScheduleManagement(p);
        if(deleteResult == 0) throw new DataNotFoundException();
        return deleteResult;
    }

    public int updateScheduleManagement(ScheduleManagementPatchReq p) throws Exception {
        int result = mapper.updateScheduleManagement(p);
        if(result == 0) throw new DataNotFoundException();
        return result;
    }

    public List<ScheduleManagementGetMonthRes> getScheduleManagementMonth(ScheduleManagementGetMonthReq p){
        return mapper.selScheduleManagementMonth(p);
    }

    public ResponseDTO2 selScheduleManagementDay(ScheduleManagementGetDayReq p){
        List<ScheduleManagementGetDayRes> list = mapper.selScheduleManagementDay(p);
        int hasMorePage = mapper.getTotalElement(p);
        ResponseDTO2 dto = new ResponseDTO2(list, p.getSize(), mapper.getTotalElement(p));
        boolean hasNextPage = (p.getPage() * GlobalConst.MORE_PAGE_SIZE < hasMorePage);
        for(ScheduleManagementGetDayRes r : list){
            boolean isMorePaging = (p.getPage() % GlobalConst.MORE_PAGE_SIZE == 0) && hasNextPage;
            r.setIsMorePaging( isMorePaging ? 1 : 0 );
        }
        return dto;
    }

    public ScheduleManagementGetDayDetailRes selScheduleManagementDetail(ScheduleManagementGetDayDetailReq p){
        return mapper.selScheduleManagementDetail(p);
    }
}
