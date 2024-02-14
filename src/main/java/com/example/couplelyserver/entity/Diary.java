package com.example.couplelyserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor  //파라미터가 없는 기본 생성자를 생성
@Getter
@Entity
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 1,2,3..자동 생성 전략
    //데이터베이스가 id를 알아서 넣을 수 있도록 바꾸기!
    private Long diaryId;   //다이어리 id(서버용)

    @Column //DB에서 관리하는 테이블이라는 단위에 연결되게 함!
    private String title;  //다이어리 작성할 때 쓸 제목
    @Column
    private String date;    //설정할 날짜
    @Column
    private String content; //다이어리 글 내용

    public void patch(Diary diary) {
        if (diary.title!=null)
            this.title=diary.title;
        if (diary.date!=null)
            this.date=diary.date;
        if(diary.content!=null)
            this.content= diary.content;
    }
}
