package com.taeyoung.boardpractice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taeyoung.boardpractice.constant.ApiPattern;
import com.taeyoung.boardpractice.dto.request.user.SignInDto;
import com.taeyoung.boardpractice.dto.request.user.SignupDto;
import com.taeyoung.boardpractice.dto.response.ResponseDto;
import com.taeyoung.boardpractice.dto.response.user.SignInResponseDto;
import com.taeyoung.boardpractice.dto.response.user.SignUpResponseDto;
import com.taeyoung.boardpractice.service.AuthService;



@RestController
@RequestMapping(ApiPattern.USER)
public class AuthContoller {
    
    private final String SIGN_UP = "/sign-up";
    private final String SIGN_IN = "/sign-in";

    @Autowired private AuthService authService;

    @PostMapping(SIGN_UP)
    public ResponseDto<SignUpResponseDto> signUp(@Valid @RequestBody SignupDto requestBody) {
        ResponseDto<SignUpResponseDto> response = authService.signUp(requestBody);        
        return response;
    }

    @PostMapping(SIGN_IN)
    public ResponseDto<SignInResponseDto> signIn(@RequestBody SignInDto requestBody) {
        ResponseDto<SignInResponseDto> response = authService.signIn(requestBody);
        return response;
    }

}
