package com.example.couplelyserver.dto;
import com.example.couplelyserver.entity.Calendar;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class CalendarDto {
    private Long calendarId;
    private Long date;

    public Calendar toEntity(){
        return new Calendar(calendarId,date);
    }
}
