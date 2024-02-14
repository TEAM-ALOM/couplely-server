package com.example.couplelyserver.entity;

import com.example.couplelyserver.dto.PlanDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Getter
@ToString
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor  //파라미터가 없는 기본 생성자를 생성
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;

    @ManyToOne
    @JoinColumn(name="linkedCalendarId")
    private Calendar calendar;

    @Column
    private String who;

    @Column
    private String body;    //일정 내용

    @Column
    private String startTime;    //일정 시작 날짜

    @Column
    private String finishTime;  //일정 종료 날짜

    public static Plan createPlan(PlanDto dto, Calendar calendar){
        //예외 발생
        if(dto.getPlanId()!=null)
            throw new IllegalArgumentException("일정 생성 실패! 일정의 id가 없어야합니다.");
        if(dto.getLinkedCalenderId()!=calendar.getCalendarId())
            throw new IllegalArgumentException("일정 생성 실패! 다이어리의 id가 잘못되었습니다.");

        //엔티티 생성 및 변환
        return new Plan(
                dto.getPlanId(),
                calendar,
                dto.getWho(),
                dto.getBody(),
                dto.getStartTime(),
                dto.getFinishTime()
        );
    }

    public void patch(PlanDto dto){
        //예외 발생
        if (this.planId!=dto.getPlanId())
            throw new IllegalArgumentException("일정 수정 실패! 잘못된 id가 입력되었습니다.");

        //객체를 갱신
        if(dto.getWho()!=null)
            this.who=dto.getWho();
        if(dto.getBody()!=null)
            this.body=dto.getBody();
        if(dto.getStartTime()!=null)
            this.startTime=dto.getStartTime();
        if(dto.getFinishTime()!=null)
            this.finishTime=dto.getFinishTime();
    }
}
