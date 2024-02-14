package com.example.couplelyserver.service;

import com.example.couplelyserver.entity.Calendar;
import com.example.couplelyserver.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CalendarService {
    @Autowired
    private CalendarRepository calendarRepository;

    //전체 캘린더 모든 일자 조회(1일~31일 조회)
    public ArrayList<com.example.couplelyserver.entity.Calendar> index() {
        return calendarRepository.findAll();
    }
    //특정 날짜 조회
    public Calendar show(Long calendarId) {
        return calendarRepository.findById(calendarId).orElse(null);
    }

}
