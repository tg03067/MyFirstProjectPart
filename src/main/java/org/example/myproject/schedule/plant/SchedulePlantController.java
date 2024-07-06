package org.example.myproject.schedule.plant;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.myproject.common.dto.ResultDto;
import org.example.myproject.common.exception.DataNotFoundException;
import org.example.myproject.common.page.ResponseDTO2;
import org.example.myproject.schedule.plant.model.*;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/schedule/plant")
@Tag(name = "식물관리", description = "식물등록관련 CRUD")
public class SchedulePlantController {
    private final SchedulePlantService service;

    @PostMapping
    @Operation(summary = "식물 등록", description = "식물등록관련 Post")
    public ResultDto<Integer> insSchedulePlant(@RequestBody SchedulePlantPostReq p){
        try {
            int result = service.insSchedule(p);

            return ResultDto.<Integer>builder().
                    code(1).
                    msg("정상적으로 등록되었습니다.").
                    data(result).
                    build();
        } catch (DataNotFoundException e){
            e.printStackTrace();
            return ResultDto.<Integer>builder().code(-1).msg("등록실패").build();
        } catch (Exception e){
            e.printStackTrace();
            return ResultDto.<Integer>builder().code(-2).msg("오류발생").build();
        }
    }

    @PatchMapping
    @Operation(summary = "식물 등록 수정", description = "식물등록관련 Patch")
    public ResultDto<Integer> updSchedulePlant(@RequestBody SchedulePlantPatchReq p){
        try {
            int result = service.updateSchedule(p);

            return ResultDto.<Integer>builder().
                    code(1).
                    msg("정상적으로 수정되었습니다.").
                    data(result).
                    build();
        } catch (DataNotFoundException e){
            e.printStackTrace();
            return ResultDto.<Integer>builder().code(-1).msg("수정실패").build();
        } catch (Exception e){
            e.printStackTrace();
            return ResultDto.<Integer>builder().code(-2).msg("오류발생").build();
        }

    }
    @DeleteMapping
    @Operation(summary = "식물 등록 삭제", description = "식물등록관련 Delete")
    public ResultDto<Integer> deleteSchedulePlant(@ParameterObject @ModelAttribute SchedulePlantDeleteReq p){
        try {
            int result = service.deleteSchedule(p);

            return ResultDto.<Integer>builder().
                    code(1).
                    msg("정상적으로 삭제되었습니다.").
                    data(result).
                    build();
        } catch (DataNotFoundException e){
            e.printStackTrace();
            return ResultDto.<Integer>builder().code(-1).msg("삭제실패").build();
        } catch (Exception e){
            e.printStackTrace();
            return ResultDto.<Integer>builder().code(-2).msg("오류발생").build();
        }
    }

    @GetMapping("/list")
    @Operation(summary = "식물등록리스트 조회", description = "식물등록관련 ListGet")
    public ResultDto<ResponseDTO2> selSchedulePlantList(@ParameterObject
                                                           @ModelAttribute SchedulePlantGetListReq p) {
        try {
            ResponseDTO2 dto = service.selSchedulePlantList(p);

            return ResultDto.<ResponseDTO2>builder().
                    code(1).
                    msg(HttpStatus.OK.toString()).
                    data(dto).
                    build();
        } catch (Exception e){
            e.printStackTrace();
            return ResultDto.<ResponseDTO2>builder().code(-1).msg("오류발생").build();
        }
    }

    @GetMapping("/detail")
    @Operation(summary = "식물등록리스트 상세 조회", description = "식물등록관련 DetailGet")
    public ResultDto<SchedulePlantGetDetailRes> selSchedulePlantDetail(@ParameterObject @ModelAttribute SchedulePlantGetDetailReq p) {
        try {
            SchedulePlantGetDetailRes result = service.selSchedulePlant(p);

            return ResultDto.<SchedulePlantGetDetailRes>builder().
                    code(1).
                    msg(HttpStatus.OK.toString()).
                    data(result).
                    build();
        } catch (Exception e){
            e.printStackTrace();
            return ResultDto.<SchedulePlantGetDetailRes>builder().code(-1).msg("오류발생").build();
        }
    }
}
