package com.example.couplelyserver.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="USER")
public class User {
    @Id
    private String userId; //pk, 사용자가 회원가입할 때 입력하는 Id라서 String으로 함
    @Column
    private String userPassword;
    @Column
    private String userName;
    @Column
    private LocalDate startDate;
    @Column
    private String profilePhoto;
    @Column
    private String userGender;

    @ManyToOne
    @JoinColumn(name="calendarId")
    private Calendar calendar;  //사실 잘 모르겠음


}
