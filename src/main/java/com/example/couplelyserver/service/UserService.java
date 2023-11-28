package com.example.couplelyserver.service;


import com.example.couplelyserver.model.DTO.JoinRequest;
import com.example.couplelyserver.model.DTO.LoginRequest;
import com.example.couplelyserver.model.Entity.User;
import com.example.couplelyserver.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    //id 중복 체크
    public boolean checkLoginIdDuplicate(String loginId){
        return userRepository.existsByLoginId(loginId);
    }
    //이름 중복 체크
    public boolean checkUserNameDuplicate(String userName){
        return userRepository.existsByUserName(userName);
    }
    //회원가입기능 암호화x
    public void join(JoinRequest req){
        userRepository.save(req.toEntity());
    }
    //회원가입기능 암호화o
    public void join2(JoinRequest req){
        userRepository.save(req.toEntity(encoder.encode(req.getPassword())));
    }
    //로그인 기능
    public User login(LoginRequest req){
        Optional<User> optionalUser =userRepository.findByLoginId(req.getLoginId());
        //아이디가 다르면
        if(optionalUser.isEmpty())
            return null;
        User user = optionalUser.get();
        //비번이 다르면
        if(!user.getUserPassword().equals(req.getPassword()))
            return null;

        return user;
    }
    public  User getLoginUserById(Long userId){
        if(userId==null)
            return null;
        Optional<User> optionalUser =userRepository.findById(userId);
        if(optionalUser.isEmpty()) return null;
        return optionalUser.get();
    }
    public User getLoginUserByLoginId(String loginId) {
        if(loginId == null) return null;

        Optional<User> optionalUser = userRepository.findByLoginId(loginId);
        if(optionalUser.isEmpty()) return null;

        return optionalUser.get();
    }
}
