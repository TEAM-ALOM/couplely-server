package com.example.couplelyserver;

import com.example.couplelyserver.entity.Calendar;
import com.example.couplelyserver.entity.Diary;
import com.example.couplelyserver.entity.Plan;
import com.example.couplelyserver.repository.CalendarRepository;
import com.example.couplelyserver.repository.DiaryRepository;
import com.example.couplelyserver.repository.PlanRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class InitDb {
    private final InitService initService;
    @PostConstruct
    public void init(){
        initService.dbInit1();
    }
    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{
        private final CalendarRepository calendarRepository;
        private final PlanRepository planRepository;
        private final DiaryRepository diaryRepository;

        public void dbInit1() {
            System.out.println("Init1" + this.getClass());
            Calendar calendar1 = new Calendar(1L, 1L);
            calendarRepository.save(calendar1);

            Calendar calendar2 = new Calendar(2L, 2L);
            calendarRepository.save(calendar2);

            Calendar calendar3 = new Calendar(3L, 3L);
            calendarRepository.save(calendar3);

            Calendar calendar4 = new Calendar(4L, 4L);
            calendarRepository.save(calendar4);

            Calendar calendar5 = new Calendar(5L, 5L);
            calendarRepository.save(calendar5);

            Calendar calendar6 = new Calendar(6L, 6L);
            calendarRepository.save(calendar6);

            Calendar calendar7 = new Calendar(7L, 7L);
            calendarRepository.save(calendar7);

            Calendar calendar8 = new Calendar(8L, 8L);
            calendarRepository.save(calendar8);

            Calendar calendar9 = new Calendar(9L, 9L);
            calendarRepository.save(calendar9);

            Calendar calendar10 = new Calendar(10L, 10L);
            calendarRepository.save(calendar10);

            Calendar calendar11 = new Calendar(11L, 11L);
            calendarRepository.save(calendar11);

            Calendar calendar12 = new Calendar(12L, 12L);
            calendarRepository.save(calendar12);

            Calendar calendar13 = new Calendar(13L, 13L);
            calendarRepository.save(calendar13);

            Calendar calendar14 = new Calendar(14L, 14L);
            calendarRepository.save(calendar14);

            Calendar calendar15 = new Calendar(15L, 15L);
            calendarRepository.save(calendar15);

            Calendar calendar16 = new Calendar(16L, 16L);
            calendarRepository.save(calendar16);

            Calendar calendar17 = new Calendar(17L, 17L);
            calendarRepository.save(calendar17);

            Calendar calendar18 = new Calendar(18L, 18L);
            calendarRepository.save(calendar18);

            Calendar calendar19 = new Calendar(19L, 19L);
            calendarRepository.save(calendar19);

            Calendar calendar20 = new Calendar(20L, 20L);
            calendarRepository.save(calendar20);

            Calendar calendar21 = new Calendar(21L, 21L);
            calendarRepository.save(calendar21);

            Calendar calendar22 = new Calendar(22L, 22L);
            calendarRepository.save(calendar22);

            Calendar calendar23 = new Calendar(23L, 23L);
            calendarRepository.save(calendar23);

            Calendar calendar24 = new Calendar(24L, 24L);
            calendarRepository.save(calendar24);

            Calendar calendar25 = new Calendar(25L, 25L);
            calendarRepository.save(calendar25);

            Calendar calendar26 = new Calendar(26L, 26L);
            calendarRepository.save(calendar26);

            Calendar calendar27 = new Calendar(27L, 27L);
            calendarRepository.save(calendar27);

            Calendar calendar28 = new Calendar(28L, 28L);
            calendarRepository.save(calendar28);

            Calendar calendar29 = new Calendar(29L, 29L);
            calendarRepository.save(calendar29);

            Calendar calendar30 = new Calendar(30L, 30L);
            calendarRepository.save(calendar30);

            Calendar calendar31 = new Calendar(31L, 31L);
            calendarRepository.save(calendar31);

            //***********Plan***********

            //4번 캘린더(4일)에 달린 일정들
            Plan plan1=new Plan(1L,calendar4,"alom-e","alom's plan1(4)","00:00","24:00");
            planRepository.save(plan1);

            Plan plan2=new Plan(2L,calendar4,"dalom-e","dalom's plan1(4)","00:00","24:00");
            planRepository.save(plan2);

            //5번 캘린더(5일)에 달린 일정들
            Plan plan3=new Plan(3L,calendar5,"alom&dalom","300days Anniversary","00:00","24:00");
            planRepository.save(plan3);

            Plan plan4=new Plan(4L,calendar6,"alom-e","interview","14:30","15:00");
            planRepository.save(plan4);

            Plan plan5=new Plan(5L,calendar6,"dalom-e","friends","17:00","22:00");
            planRepository.save(plan4);

            //***********Diary***********
            Diary diary1 = new Diary(1L, "title 1", "day 1", "content 1");
            diaryRepository.save(diary1);

            Diary diary2 = new Diary(2L, "title 2", "day 2", "content 2");
            diaryRepository.save(diary2);

            Diary diary3 = new Diary(3L, "title 3", "day 3", "content 3");
            diaryRepository.save(diary3);

            Diary diary4 = new Diary(4L, "title 4", "day 4", "content 4");
            diaryRepository.save(diary4);

            Diary diary5 = new Diary(5L, "title 5", "day 5", "content 5");
            diaryRepository.save(diary5);

            Diary diary6 = new Diary(6L, "title 6", "day 6", "content 6");
            diaryRepository.save(diary6);


        }
    }
}