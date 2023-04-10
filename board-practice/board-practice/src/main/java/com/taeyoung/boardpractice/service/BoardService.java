package com.taeyoung.boardpractice.service;

import org.springframework.stereotype.Service;

import com.taeyoung.boardpractice.dto.request.board.PostBoardDto;
import com.taeyoung.boardpractice.dto.response.ResponseDto;
import com.taeyoung.boardpractice.dto.response.board.PostBoardResponseDto;

@Service
public interface BoardService {
    
    public ResponseDto<PostBoardResponseDto> postBoard(String email, PostBoardDto boardDto);

}
