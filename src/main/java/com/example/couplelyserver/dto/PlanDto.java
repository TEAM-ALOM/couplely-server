package com.example.couplelyserver.dto;

import com.example.couplelyserver.entity.Plan;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class PlanDto {
    @JsonProperty("plan_id")
    private Long planId;

    @JsonProperty("linked_calendar_id")
    private Long linkedCalenderId;
    private String who;
    private String body;
    private String startTime;
    private String finishTime;

    public static PlanDto createPlanDto(Plan p){
        return new PlanDto(
                p.getPlanId(),
                p.getCalendar().getCalendarId(),
                p.getWho(),
                p.getBody(),
                p.getStartTime(),
                p.getFinishTime()
        );
    }

}
