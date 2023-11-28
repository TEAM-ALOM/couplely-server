package com.example.couplelyserver.model.Entity;

import com.example.couplelyserver.model.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId; //pk,

    /* @Column(unique = true,length = 30, nullable = true)
     @NotNull*/
    private  String loginId;// 사용자가 회원가입할 때 입력하는 Id라서 String으로 함

    /* @Column(length = 30, nullable = true)
     @NotNull*/
    private String userPassword;
    // @Column
    private String userName;
    //@Column
    private LocalDate startDate;
    //@Column
    private String profilePhoto;
    //@Column
    private String userGender;

    private UserRole role;

    @OneToMany(mappedBy = "user")
    private List<Diary> diaries = new ArrayList<Diary>();
    @OneToMany(mappedBy = "user")
    private List<Calendar> calendars = new ArrayList<Calendar>();

}
