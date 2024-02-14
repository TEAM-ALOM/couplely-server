package com.example.couplelyserver.dto;

import com.example.couplelyserver.entity.Diary;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DiaryDto {
    //필드 선언
    private Long diaryId;   //id필드 추가
    private String title;
    private String date;
    private String content;


    public Diary toEntity() {
        return new Diary(diaryId,title,date,content);
    }
}
