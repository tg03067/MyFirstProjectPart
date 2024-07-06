package org.example.myproject.schedule.plant;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.myproject.common.GlobalConst;
import org.example.myproject.common.exception.DataNotFoundException;
import org.example.myproject.common.page.ResponseDTO2;
import org.example.myproject.schedule.plant.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SchedulePlantService {
    private final SchedulePlantMapper mapper;

    public int insSchedule(SchedulePlantPostReq p) throws Exception {
        int result = mapper.insSchedule(p);
        if(result == 0) throw new DataNotFoundException();
        return result;
    }
    public int updateSchedule(SchedulePlantPatchReq p) throws Exception{
        int result = mapper.updateSchedule(p);
        if(result == 0) throw new DataNotFoundException();
        return result;
    }
    public int deleteSchedule(SchedulePlantDeleteReq p) throws Exception{
        int result = mapper.deleteSchedule(p);
        if(result == 0) throw new DataNotFoundException();
        return result;
    }
    public ResponseDTO2 selSchedulePlantList(SchedulePlantGetListReq p){
        System.out.println("Request Parameters: " + p.toString());
        List<SchedulePlantGetListRes> list = mapper.getSchedulePlantsList(p);
        System.out.println("SQL Query Result: " + list);

        int total = mapper.getTotal(p);
        ResponseDTO2 dto = new ResponseDTO2(list, p.getSize(), mapper.getTotal(p));
        boolean hasNextPage = ( p.getPage() * GlobalConst.SIZE_NUM < total);
        for(SchedulePlantGetListRes res : list){
            boolean isMorePage = (p.getPage() % 5 == 0) && hasNextPage ;
            res.setIsMorePage( isMorePage ? 1 : 0 );
        }

        return dto;
    }
    public SchedulePlantGetDetailRes selSchedulePlant(SchedulePlantGetDetailReq p){
        return mapper.getSchedulePlantDetail(p);
    }
}
