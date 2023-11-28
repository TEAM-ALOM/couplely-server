package com.example.couplelyserver.model.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PLANCALENDAR")
public class PlanCalendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pcId;//다이어리 id
    @ManyToOne
    @JoinColumn(name="PLAN_ID")
    private Plan plan;

    @ManyToOne
    @JoinColumn(name="CALENDAR_ID")
    private Calendar calendar;

}
