package com.example.couplelyserver.model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CALENDAR_ID")
    private int calendarId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USER_ID")
    private User user;



    @OneToMany(mappedBy = "calendar")
    private List<PlanCalendar> planCalendars;

    @OneToMany(mappedBy = "calendar")
    private List<DiaryCalendar> diaryCalendars;
}
