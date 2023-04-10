package com.taeyoung.boardpractice.dto.response.board;

import com.taeyoung.boardpractice.entity.BoardEntity;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class PostBoardResponseDto {

    private BoardEntity boardEntity;

    public PostBoardResponseDto(BoardEntity boardEntity) {
        this.boardEntity = boardEntity;
    }

}
