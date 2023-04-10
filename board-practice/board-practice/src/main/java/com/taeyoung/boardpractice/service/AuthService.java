package com.taeyoung.boardpractice.service;

import org.springframework.stereotype.Service;

import com.taeyoung.boardpractice.dto.request.user.SignInDto;
import com.taeyoung.boardpractice.dto.request.user.SignupDto;
import com.taeyoung.boardpractice.dto.response.ResponseDto;
import com.taeyoung.boardpractice.dto.response.user.SignInResponseDto;
import com.taeyoung.boardpractice.dto.response.user.SignUpResponseDto;

@Service
public interface AuthService {
    public ResponseDto<SignUpResponseDto> signUp(SignupDto dto);
    public ResponseDto<SignInResponseDto> signIn(SignInDto dto);
}
