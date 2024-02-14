package com.example.couplelyserver.controller;

import com.example.couplelyserver.dto.DiaryDto;
import com.example.couplelyserver.entity.Diary;
import com.example.couplelyserver.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiaryController {
    @Autowired
    private DiaryService diaryService;

    @GetMapping("api/diary")
    public List<Diary> index(){
        return diaryService.index();
    }
    @GetMapping("api/diary/{diaryId}")
    public Diary show(@PathVariable Long diaryId) {
        return diaryService.show(diaryId);
    }

    @PostMapping("/api/diary")
    public ResponseEntity<Diary> create(@RequestBody DiaryDto dto) {
        Diary created = diaryService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PatchMapping("api/diary/{diaryId}")
    public ResponseEntity<Diary> update(@PathVariable Long diaryId,
                                        @RequestBody DiaryDto dto) {
        Diary updated = diaryService.update(diaryId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @DeleteMapping("api/diary/{diaryId}")
    public ResponseEntity<Diary> delete(@PathVariable Long diaryId) {
        Diary deleted = diaryService.delete(diaryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/api/transaction-test")
    public ResponseEntity<List<Diary>> transactionTest(@RequestParam List<DiaryDto> dtos) {
        List<Diary> createdList = diaryService.createDiary(dtos);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdList);
    }
}
