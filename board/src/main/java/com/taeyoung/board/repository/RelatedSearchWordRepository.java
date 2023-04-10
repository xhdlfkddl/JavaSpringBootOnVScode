package com.taeyoung.board.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taeyoung.board.entity.RelatedSearchWordEntity;
import com.taeyoung.board.entity.resultSet.RelatedSearchWordResultSet;

@Repository
public interface RelatedSearchWordRepository extends JpaRepository<RelatedSearchWordEntity, Integer> {
    
    @Query(value=
                "SELECT previous_search_word AS PreviousSearchWord, count(previous_search_word) AS count " + 
                "FROM Relatedsearchword " + 
                "WHERE search_word = ?1 " +
                "GROUP BY previous_search_word " + 
                "ORDER BY count DESC " + 
                "LIMIT 15", nativeQuery=true)
    public List<RelatedSearchWordResultSet> findTop15(String searchWord);

}
