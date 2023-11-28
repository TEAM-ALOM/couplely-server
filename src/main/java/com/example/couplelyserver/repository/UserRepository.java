package com.example.couplelyserver.repository;

import com.example.couplelyserver.model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //추가 매서드는 삽입
    boolean existsByLoginId(String loginId);
    boolean existsByUserName(String username);
    Optional<User> findByLoginId(String loginId);

}
