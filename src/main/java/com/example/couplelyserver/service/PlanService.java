package com.example.couplelyserver.service;

import com.example.couplelyserver.dto.PlanDto;
import com.example.couplelyserver.entity.Calendar;
import com.example.couplelyserver.entity.Plan;
import com.example.couplelyserver.repository.CalendarRepository;
import com.example.couplelyserver.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanService {
    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private CalendarRepository calendarRepository;

    public List<PlanDto> plans(Long linkedCalendarId) {
        //조회 : 모든 일정 조회
        List<Plan> plans=planRepository.findByLinkedCalendarId(linkedCalendarId);

        //반환
        return planRepository.findByLinkedCalendarId(linkedCalendarId)
                .stream()
                .map(plan->PlanDto.createPlanDto(plan))
                .collect(Collectors.toList());
    }

    @Transactional
    public PlanDto create(Long linkedCalendarId,PlanDto dto){
        //캘린더 조회 및 예외 발생
        Calendar calendar=calendarRepository.findById(linkedCalendarId)
                .orElseThrow(()->new IllegalArgumentException("일정 생성 실패! 대상 캘린더가 없습니다."));
        //일정 엔티티 생성
        Plan plan=Plan.createPlan(dto,calendar);
        //일정 엔티티를 DB로 저장
        Plan created=planRepository.save(plan);
        //DTO로 변경하여 반환
        return PlanDto.createPlanDto(created);
    }
    @Transactional  //데이터를 건드리니까 써줘야 함
    public PlanDto update(Long planId, PlanDto dto) {
        //일정 조회 및 예외 발생
        Plan target = planRepository.findById(planId)
                .orElseThrow(()->new IllegalArgumentException("일정 수정 실패! 대상 일정이 없습니다."));

        //일정 수정
        target.patch(dto);

        //수정된 일정을 DB로 갱신
        Plan updated = planRepository.save(target);

        //일정entity를 dto로 변환 및 반환
        return PlanDto.createPlanDto(updated);
    }

    @Transactional
    public PlanDto delete(Long planId){
        //일정 조회 및 예외 발생
        Plan target=planRepository.findById(planId)
                .orElseThrow(()->new IllegalArgumentException("일정 삭제 실패! 대상이 없습니다."));
        //일정 DB에서 삭제
        planRepository.delete(target);
        //삭제 일정을 dto로 반환
        return PlanDto.createPlanDto(target);
    }
}
