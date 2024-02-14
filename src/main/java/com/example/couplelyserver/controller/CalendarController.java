package com.example.couplelyserver.controller;
import com.example.couplelyserver.entity.Calendar;
import com.example.couplelyserver.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class CalendarController {
    @Autowired
    private CalendarService calendarService;

    //전체 날짜(1일~31일)
    @GetMapping("api/calendar")
    public List<Calendar> index(){
        return calendarService.index();
    }

    //특정 날짜 조회(n일)
    @GetMapping("api/calendar/{calendarId}")
    public Calendar show(@PathVariable Long calendarId){
        return calendarService.show(calendarId);
    }
}
