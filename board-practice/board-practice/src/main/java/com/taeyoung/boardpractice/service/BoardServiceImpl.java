package com.taeyoung.boardpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taeyoung.boardpractice.constant.ResponseMessage;
import com.taeyoung.boardpractice.dto.request.board.PostBoardDto;
import com.taeyoung.boardpractice.dto.response.ResponseDto;
import com.taeyoung.boardpractice.dto.response.board.PostBoardResponseDto;
import com.taeyoung.boardpractice.entity.BoardEntity;
import com.taeyoung.boardpractice.entity.UserEntity;
import com.taeyoung.boardpractice.repository.BoardRepository;
import com.taeyoung.boardpractice.repository.UserRepository;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired private UserRepository userRepository;
    @Autowired private BoardRepository boardRepository;

    @Override
    public ResponseDto<PostBoardResponseDto> postBoard(String email, PostBoardDto boardDto) {
        PostBoardResponseDto data = null;
        
        try {
            
            if (!userRepository.existsByEmail(email)) return ResponseDto.setFail(ResponseMessage.NO_MATCH_USER);
            UserEntity userEntity = userRepository.findByEmail(email);

            BoardEntity boardEntity = new BoardEntity(userEntity, boardDto);
            boardRepository.save(boardEntity);

            data = new PostBoardResponseDto(boardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATA_BASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
    
}
