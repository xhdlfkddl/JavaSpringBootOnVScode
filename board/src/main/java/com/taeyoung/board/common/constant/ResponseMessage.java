package com.taeyoung.board.common.constant;

public interface ResponseMessage {
    public static final String SUCCESS = "Success.";
    
    public static final String FAIL_SIGN_IN = "Failed sign in.";
    
    public static final String  NOT_EXIST_USER = "Does not exist user.";
    public static final String  NOT_EXIST_BOARD = "Does not exist board.";

    public static final String  NOT_PERMISSION = "Do not have permission.";

    public static final String EXIST_EMAIL = "Existed email.";
    public static final String EXIST_NICKNAME = "Existed nickname.";
    public static final String EXIST_TEL_NUMBER = "Existed tel number.";

    public static final String DATABASE_ERROR = "Database error.";
}
