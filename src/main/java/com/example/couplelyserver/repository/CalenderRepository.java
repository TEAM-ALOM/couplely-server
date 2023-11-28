package com.example.couplelyserver.repository;

import com.example.couplelyserver.model.Entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalenderRepository extends JpaRepository<Calendar, Integer> {
}
