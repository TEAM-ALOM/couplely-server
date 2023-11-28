package com.example.couplelyserver.model.DTO;

import com.example.couplelyserver.model.Entity.User;
import com.example.couplelyserver.model.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class JoinRequest {

    @NotBlank(message = "로그인 아이디가 비어있습니다.")
    private String loginId;

    @NotBlank(message = "비밀번호가 비어있습니다.")
    private String password;
    private String passwordCheck;

    @NotBlank(message = "닉네임이 비어있습니다.")
    private String username;

    @NotBlank(message = "성별이 비어있습니다.")
    private String usergender;

    @NotBlank(message = "사귄날짜가 비어있습니다")
    private LocalDate startdate;

    // 비밀번호 암호화 X
    public User toEntity() {
        return User.builder()
                .loginId(this.loginId)
                .userPassword(this.password)
                .userName(this.username)
                .userGender(this.usergender)
                .startDate(this.startdate)
                .role(UserRole.USER)
                .build();
    }

    // 비밀번호 암호화
    public User toEntity(String encodedPassword) {
        return User.builder()
                .loginId(this.loginId)
                .userPassword(encodedPassword)
                .userName(this.username)
                .userGender(this.usergender)
                .startDate(this.startdate)
                .role(UserRole.USER)
                .build();
    }
}
