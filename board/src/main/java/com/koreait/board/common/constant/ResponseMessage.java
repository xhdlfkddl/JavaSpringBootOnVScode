package com.koreait.board.common.constant;

public class ResponseMessage {
    // instance 생성하지 않기 위해서 static
    // public을 붙여야 다른 패키지에서도 사용 가능
    public static final String DATABASE_ERROR = "Database Error!!";

    public static final String SUCCESS = "Success!!";
    public static final String FAIL = "Failㅠㅠ";
    
    public static final String EXIST_TELEPHONE_NUMBER = "Already used phonenumber";
    public static final String EXIST_DEPARTMENT_CODE = "Already existed department code";

    public static final String NOT_EXIST_DEPARTMENT_CODE = "Does not exist department code";
    public static final String NOT_EXIST_EMPLOYEE_NUMBER = "Does not exist employee number";
}
