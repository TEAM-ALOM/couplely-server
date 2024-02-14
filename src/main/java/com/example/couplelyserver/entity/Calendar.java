package com.example.couplelyserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor  //파라미터가 없는 기본 생성자를 생성
@Getter
@Entity
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CalendarId;

    @Column
    private Long date;


    public void patch(Calendar calendar){
        if(calendar.date!=null)
            this.date=calendar.date;
    }

}
