package com.taeyoung.boardpractice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taeyoung.boardpractice.constant.ApiPattern;
import com.taeyoung.boardpractice.dto.request.board.PostBoardDto;
import com.taeyoung.boardpractice.dto.response.ResponseDto;
import com.taeyoung.boardpractice.dto.response.board.PostBoardResponseDto;
import com.taeyoung.boardpractice.service.BoardService;

@RestController
@RequestMapping(ApiPattern.BOARD)
public class BoardController {
    
    private final String POST = "/post";

    @Autowired private BoardService boardService;

    @PostMapping(POST)
    public ResponseDto<PostBoardResponseDto> postBoard(@AuthenticationPrincipal String email, @Valid @RequestBody PostBoardDto requestBody) {
        ResponseDto<PostBoardResponseDto> response = boardService.postBoard(email, requestBody);
        return response;
    }

}
