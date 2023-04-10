package com.taeyoung.boardpractice.constant;

public class ResponseMessage {
    public static final String DATA_BASE_ERROR = "데이터베이스 오류";

    // signup
    public static final String EXIST_EMAIL = "이미 존재하는 이메일입니다.";
    public static final String EXIST_TELNUMBER = "이미 존재하는 휴대폰번호입니다.";

    // signin
    public static final String WRONG_USER_INFORMATION = "잘못된 회원정보입니다.";
    public static final String TOKEN_ERROR = "토큰 생성 과정 중 오류가 발생하였습니다.";

    // postBoard
    public static final String NO_MATCH_USER = "존재하지않는 회원정보입니다.";

    public static final String SUCCESS = "성공";
}
