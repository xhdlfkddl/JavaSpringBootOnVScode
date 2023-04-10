package com.taeyoung.board.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taeyoung.board.entity.LikeEntity;
import com.taeyoung.board.entity.primaryKey.LikyPk;

@Repository
public interface LikyRepository extends JpaRepository<LikeEntity, LikyPk> {
    
    public List<LikeEntity> findByBoardNumber(int boardNumber);

    public LikeEntity findByUserEmailAndBoardNumber(String userEmail, int boardNumber);

    @Transactional
    public void deleteByBoardNumber(int boardNumber);
}