package com.taeyoung.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taeyoung.board.entity.BoardEntity;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    //    
    public BoardEntity findByBoardNumber(int boardNumber);
    // 정렬: OrderBy, 기준: BoardWriteDatetime, 역순: Desc
    // = 최신순으로 가져옴
    public List<BoardEntity> findByOrderByBoardWriteDatetimeDesc();
    //
    public List<BoardEntity> findByWriterEmailOrderByBoardWriteDatetimeDesc(String writerEmail);
    // SELECT * FROM Board WHERE board_title like %a%
    public List<BoardEntity> findByBoardTitleContainsOrBoardContentContainsOrderByBoardWriteDatetimeDesc(String boardTitle, String boardContent);
    //
    public List<BoardEntity> findTop3ByBoardWriteDatetimeGreaterThanOrderByLikeCountDesc(String aWeekAge);


    // 예시
    // @Query("SELECT * FROM board.relatedsearchword WHERE search_word = '안녕'")
    // public List<BoardEntity> findA();


}
