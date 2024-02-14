package com.example.couplelyserver.controller;

import com.example.couplelyserver.dto.PlanDto;
import com.example.couplelyserver.service.PlanService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlanController {
    @Autowired
    private PlanService planService;

    //일정 목록 조회
    @GetMapping("api/calendar/{linkedCalendarId}/plans")
    public ResponseEntity<List<PlanDto>> plans(@PathVariable Long linkedCalendarId){
        //서비스에게 위임해서 리스트 가져오기
        List<PlanDto>dtos=planService.plans(linkedCalendarId);

        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    //일정 생성
    @PostMapping("api/calendar/{linkedCalendarId}/plans")
    public ResponseEntity<PlanDto> create(@PathVariable Long linkedCalendarId,
                                          @RequestBody PlanDto dto){
        //서비스에게 위임
        PlanDto createdDto=planService.create(linkedCalendarId,dto);

        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    //일정 수정
    @PatchMapping("api/plans/{planId}")
    public ResponseEntity<PlanDto> update(@PathVariable Long planId,
                                          @RequestBody PlanDto dto){
        //서비스에게 위임
        PlanDto updatedDto = planService.update(planId,dto);

        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }

    //일정 삭제
    @DeleteMapping("api/plans/{plansId}")
    public ResponseEntity<PlanDto> delete(@PathVariable Long planId){
        //서비스에게 위임
        PlanDto updatedDto = planService.delete(planId);

        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }

}
