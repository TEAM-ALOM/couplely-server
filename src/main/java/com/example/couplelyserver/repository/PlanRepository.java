package com.example.couplelyserver.repository;

import com.example.couplelyserver.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan,Long> {
    //특정 날짜의 모든 일정 조회
    @Query(value =
            "SELECT * "+ "FROM plan " +
                    "WHERE linked_calendar_id = :linkedCalendarId",
            nativeQuery = true)
    List<Plan> findByLinkedCalendarId(@Param("linkedCalendarId") Long linkedCalendarId);


    // 특정 사람(name)의 모든 댓글 조회
    @Query(name = "Plan.findByWho")
    List<Plan> findByWho(@Param("name") String who);
    //List<Plan> findByName(String name);
}
