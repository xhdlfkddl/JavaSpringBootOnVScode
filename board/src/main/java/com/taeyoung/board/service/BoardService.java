package com.taeyoung.board.service;

import java.util.List;

import com.taeyoung.board.dto.request.board.LikeDto;
import com.taeyoung.board.dto.request.board.PatchBoardDto;
import com.taeyoung.board.dto.request.board.PostBoardRequestDto;
import com.taeyoung.board.dto.request.board.PostCommentDto;
import com.taeyoung.board.dto.response.ResponseDto;
import com.taeyoung.board.dto.response.board.DeleteBoardResponseDto;
import com.taeyoung.board.dto.response.board.GetBoardResponseDto;
import com.taeyoung.board.dto.response.board.GetListResponseDto;
import com.taeyoung.board.dto.response.board.GetMyListResponseDto;
import com.taeyoung.board.dto.response.board.GetSearchListResponseDto;
import com.taeyoung.board.dto.response.board.GetTop15RelatedSearchWordResponseDto;
import com.taeyoung.board.dto.response.board.GetTop15SearchWordResponseDto;
import com.taeyoung.board.dto.response.board.GetTop3ListResponseDto;
import com.taeyoung.board.dto.response.board.LikeResponseDto;
import com.taeyoung.board.dto.response.board.PatchBoardResponseDto;
import com.taeyoung.board.dto.response.board.PostBoardResponseDto;
import com.taeyoung.board.dto.response.board.PostCommentResponseDto;

public interface BoardService {
    //
    public ResponseDto<PostBoardResponseDto> postBoard(String email, PostBoardRequestDto dto);
    // 내 게시물 리스트
    public ResponseDto<List<GetMyListResponseDto>> getMyList(String email);
    //
    public ResponseDto<List<GetSearchListResponseDto>> getSearchList (String searchWord, String previousSearchWord);
    //
    public ResponseDto<LikeResponseDto> like(String email, LikeDto dto);
    //
    public ResponseDto<List<GetTop3ListResponseDto>> getTop3List();
    //
    public ResponseDto<GetTop15SearchWordResponseDto> getTop15SearchWord();
    //
    public ResponseDto<GetTop15RelatedSearchWordResponseDto> getTop15RelatedSearchWord(String searchWord);
    //
    public ResponseDto<PostCommentResponseDto> postComment(String email, PostCommentDto dto);
    // 게시글 상세정보
    public ResponseDto<GetBoardResponseDto> getBoard(int boardNumber);
    // 게시글 순서대로 가져오기
    public ResponseDto<List<GetListResponseDto>> getList();
    // 게시글 수정
    public ResponseDto<PatchBoardResponseDto> patchBoard(String email, PatchBoardDto dto);
    // 게시물 삭제
    public ResponseDto<DeleteBoardResponseDto> deleteBoard(String email, int boardNumber);
    

}   
