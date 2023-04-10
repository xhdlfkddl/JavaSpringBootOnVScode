package com.taeyoung.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taeyoung.board.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    
    public boolean existsByEmail(String email);
    public boolean existsByNickname(String nickname);
    public boolean existsByTelNumber(String telNumber);

    // 위 3개를 합쳐놓은 것
    public boolean existsByEmailOrNicknameOrTelNumber(String email, String nickname, String telNumber);

    public UserEntity findByEmail(String email);

}