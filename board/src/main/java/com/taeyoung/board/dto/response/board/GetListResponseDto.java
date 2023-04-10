package com.taeyoung.board.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import com.taeyoung.board.entity.BoardEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "전체 게시물 리스트 가져오기 Response Body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListResponseDto {
    @ApiModelProperty(value = "게시물 번호", example = "1", required = true)
    private int     boardNumber;
    
    @ApiModelProperty(value = "게시물 제목", example = "Board title", required = true)
    private String  boardTitle;
    
    @ApiModelProperty(value = "게시물 내용", example = "Board content", required = true)
    private String  boardContent;
    
    @ApiModelProperty(value = "게시물 이미지 URL", example = "http://boardImgUrl", required = true)
    private String  boardImgUrl;

    @ApiModelProperty(value = "게시물 작성 일시", example = "2023-03-23 17:20", required = true)
    private String  boardWriteDatetime;

    @ApiModelProperty(value = "조회수", example = "30", required = true)
    private int     viewCount;

    @ApiModelProperty(value = "작성자 닉네임", example = "userNickname", required = true)
    private String  writerNickname;

    @ApiModelProperty(value = "작성자 프로필 이미지 URL", example = "http://userProfileImgUrl", required = false)
    private String  writerProfileUrl;

    @ApiModelProperty(value = "댓글 수", example = "7", required = true)
    private int     commentCount;

    @ApiModelProperty(value = "좋아요 수", example = "5", required = true)
    private int     likeCount;

    public GetListResponseDto(BoardEntity boardEntity) {
        this.boardNumber        = boardEntity.getBoardNumber();
        this.boardTitle         = boardEntity.getBoardTitle();
        this.boardContent       = boardEntity.getBoardContent();
        this.boardImgUrl        = boardEntity.getBoardImgUrl();
        this.boardWriteDatetime = boardEntity.getBoardWriteDatetime();
        this.viewCount          = boardEntity.getViewCount();
        this.writerNickname     = boardEntity.getWriterNickname();
        this.writerProfileUrl   = boardEntity.getWriterProfileUrl();
        this.commentCount       = boardEntity.getCommentCount();
        this.likeCount          = boardEntity.getLikeCount();
    }

    public static List<GetListResponseDto> copyList(List<BoardEntity> boardEntityList) {
        
        List<GetListResponseDto> list = new ArrayList<>();
        
        for (BoardEntity boardEntity : boardEntityList) {
            GetListResponseDto dto = new GetListResponseDto(boardEntity);
            list.add(dto);
        }

        return list;

    }

}
