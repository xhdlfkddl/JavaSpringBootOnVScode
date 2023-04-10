package com.taeyoung.board.entity.resultSet;

// 무언가의 결과값을 받을 때는 interface!!
public interface SearchWordResultSet {
    public String getSearchWord();
    public int getCount(); 
}