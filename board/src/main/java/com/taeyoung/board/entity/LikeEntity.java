package com.taeyoung.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.taeyoung.board.entity.primaryKey.LikyPk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Liky")
@Table(name = "Liky")
@IdClass(LikyPk.class)
public class LikeEntity {
    
    // 복합키
    @Id
    private String userEmail;

    @Id
    private int boardNumber;

    private String  userProfileUrl;
    private String  userNickname;

    //
    public LikeEntity(UserEntity userEntity, int boardNumber) {
        this.userEmail      = userEntity.getEmail();
        this.boardNumber    = boardNumber;
        this.userProfileUrl = userEntity.getProfile();
        this.userNickname   = userEntity.getNickname();
    }

}
