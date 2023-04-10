package com.taeyoung.board.service;

import com.taeyoung.board.dto.request.auth.SignInDto;
import com.taeyoung.board.dto.request.auth.SignUpDto;
import com.taeyoung.board.dto.response.ResponseDto;
import com.taeyoung.board.dto.response.auth.SignInResponseDto;
import com.taeyoung.board.dto.response.auth.SignUpResponseDto;

public interface AuthService {
    //
    public ResponseDto<SignUpResponseDto> signUp(SignUpDto dto);
    //
    public ResponseDto<SignInResponseDto> signIn(SignInDto dto);

}
