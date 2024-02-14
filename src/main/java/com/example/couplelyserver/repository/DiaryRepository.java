package com.example.couplelyserver.repository;

import com.example.couplelyserver.entity.Diary;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface DiaryRepository extends CrudRepository<Diary,Long> {
    @Override
    ArrayList<Diary> findAll();
}
