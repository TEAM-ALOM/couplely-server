package com.example.couplelyserver.service;

import com.example.couplelyserver.dto.DiaryDto;
import com.example.couplelyserver.entity.Diary;
import com.example.couplelyserver.repository.DiaryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DiaryService {
    @Autowired
    private DiaryRepository diaryRepository;

    //전체 다이어리 글 조회
    public List<Diary> index() {
        return diaryRepository.findAll();
    }

    //특정 다이어리(다이어리 id)조회
    public Diary show(Long diaryId){
        return diaryRepository.findById(diaryId).orElse(null);
    }

    //다이어리 작성하기
    public Diary create(DiaryDto dto){
        Diary diary = dto.toEntity();
        if(diary.getDiaryId()!=null){   //저장되어있으면
            return null;    //수정하지 않고 null반환
        }
        return diaryRepository.save(diary); //null이면 저장하기
    }

    //특정 다이어리 수정하기
    public Diary update(Long diaryId,DiaryDto dto){
        //1.수정용 엔티티 생성
        Diary diary = dto.toEntity();
        log.info("diaryId : {}, diary : {}",diaryId,diary.toString());
        //2.대상 엔티티 조회
        Diary target = diaryRepository.findById(diaryId).orElse(null);
        //3.잘못된 요청 처리(대상이 없거나, id가 다른 경우)
        if(target==null||diaryId != diary.getDiaryId()){
            //400, 잘못된 요청 응답 보내줘야 함
            log.info("잘못된 요청! diaryId : {}, diary : {}",diaryId,diary.toString());
            return null;
        }
        //4.업데이트 및 정상 응답(200)
        target.patch(diary);//대상을 diary엔티티로 패치하기(붙여주기)
        Diary updated = diaryRepository.save(target);//새롭게 붙여진 애를 save
        return updated;
    }

    //삭제하기
    public Diary delete(Long diaryId) {
        //대상 찾기
        Diary target= diaryRepository.findById(diaryId).orElse(null);
        //잘못된 요청 처리 삭제하려고 한 게 없을 경우
        if (target ==null){
            return null;
        }
        //대상 삭제
        diaryRepository.delete(target);

        return target;
    }
    @Transactional
    public List<Diary> createDiary(List<DiaryDto> dtos) {
        // dto 묶음을 entity 묶음으로 변환
        //stream문법
        List<Diary> diaryList = dtos.stream()
                .map(dto -> dto.toEntity())
                .collect(Collectors.toList());
        //for문
//        List<Diary> diaryList=new DiaryList<>();
//        for(int i=0;i<dtos.size();i++){
//          DiaryDto dto=dtos.get(i);
//            Diary entity = dto.toEntity();
//            diaryList.add(entity);
//        }


        //entity 묶음을 DB로 저장
        //stream
        diaryList.stream()
                .forEach(diary -> diaryRepository.save(diary));

        //for문으로 했다면?
//        for (int i=0;i<diaryList.size();i++){
//            Diary diary = diaryList.get(i);
//            diaryRepository.save(diary);
//        }

        //저장된 상태에서 강제로 에러를 발생시키기
        diaryRepository.findById(-1L).orElseThrow(
                () -> new IllegalArgumentException("fail!")
        );

        //결과값 반환
        return diaryList;
    }

}
