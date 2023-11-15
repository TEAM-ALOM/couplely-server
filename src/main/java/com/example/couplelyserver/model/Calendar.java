package com.example.couplelyserver.model;

import jakarta.persistence.*;

@Entity
@Table(name="CALENDAR")
public class Calendar {
    @Id
    @Column (name="calendarId")
    private int calendarId;

    @ManyToOne
    @JoinColumn(name="planId")
    private Plan plan;
    @ManyToOne
    @JoinColumn(name="diaryId")
    private Diary diary;
    @ManyToOne
    @JoinColumn(name="userId")
    private User user;







}
