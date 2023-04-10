package com.taeyoung.boardpractice.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.taeyoung.boardpractice.dto.request.board.PostBoardDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "board")
@Table(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardNumber;
    private String boardTitle;
    private String boardContent;
    private String boardImgUrl;
    private String boardWriteDateTime;
    private int viewCount;
    private String writerEmail;
    private String writerNickname;    
    private String writerProfileUrl;
    private int commentCount;
    private int likeCount; 

    public BoardEntity(UserEntity userEntity, PostBoardDto dto) {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

        this.boardTitle = dto.getBoardTitle();
        this.boardContent = dto.getBoardContent();
        this.boardImgUrl = dto.getBoardImgUrl();
        this.boardWriteDateTime = simpleDateFormat.format(now);
        this.viewCount = 0;
        this.writerEmail = userEntity.getEmail();
        this.writerNickname = userEntity.getNickname();
        this.writerProfileUrl = userEntity.getProfile();
        this.commentCount = 0;
        this.likeCount = 0;

    }
    
}
