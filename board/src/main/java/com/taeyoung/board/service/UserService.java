package com.taeyoung.board.service;

import com.taeyoung.board.dto.request.user.PatchProfileRequestDto;
import com.taeyoung.board.dto.request.user.ValidateEmailDto;
import com.taeyoung.board.dto.request.user.ValidateNicknameDto;
import com.taeyoung.board.dto.request.user.ValidateTelNumberDto;
import com.taeyoung.board.dto.response.ResponseDto;
import com.taeyoung.board.dto.response.user.GetUserResponseDto;
import com.taeyoung.board.dto.response.user.PatchProfileResponseDto;
import com.taeyoung.board.dto.response.user.ValidateEmailResponseDto;
import com.taeyoung.board.dto.response.user.ValidateNicknameResponseDto;
import com.taeyoung.board.dto.response.user.ValidateTelNumberResponseDto;

public interface UserService {
    
    public ResponseDto<PatchProfileResponseDto> patchProfile(String email, PatchProfileRequestDto profileDto);
    public ResponseDto<GetUserResponseDto> getUser(String email);
    public ResponseDto<ValidateEmailResponseDto> validateEmail(ValidateEmailDto dto);
    public ResponseDto<ValidateNicknameResponseDto> validateNickname(ValidateNicknameDto dto);
    public ResponseDto<ValidateTelNumberResponseDto> validateTelNumber(ValidateTelNumberDto dto);

}
