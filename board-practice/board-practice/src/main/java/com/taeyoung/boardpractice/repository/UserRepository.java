package com.taeyoung.boardpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taeyoung.boardpractice.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    
    public boolean existsByEmail(String email);
    public boolean existsByTelNumber(String telNumber);

    public UserEntity findByEmail(String email);

}
