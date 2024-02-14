package com.example.couplelyserver.repository;
import com.example.couplelyserver.entity.Calendar;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CalendarRepository extends CrudRepository<Calendar,Long> {
    @Override
    ArrayList<Calendar> findAll();
}
