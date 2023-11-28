package com.example.couplelyserver.repository;

import com.example.couplelyserver.model.Entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary,String> {
}
