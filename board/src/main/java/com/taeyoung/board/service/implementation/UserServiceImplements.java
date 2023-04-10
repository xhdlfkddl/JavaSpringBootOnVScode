package com.taeyoung.board.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taeyoung.board.common.constant.ResponseMessage;
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
import com.taeyoung.board.entity.UserEntity;
import com.taeyoung.board.repository.UserRepository;
import com.taeyoung.board.service.UserService;

@Service
public class UserServiceImplements implements UserService {
    
    @Autowired UserRepository userRepository;

    //
    public ResponseDto<PatchProfileResponseDto> patchProfile(String email, PatchProfileRequestDto profileDto) {
        
        PatchProfileResponseDto data = null;

        String profile = profileDto.getProfile();

        try {
            
            UserEntity userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER); 

            userEntity.setProfile(profile);
            userRepository.save(userEntity);

            data = new PatchProfileResponseDto(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<ValidateEmailResponseDto> validateEmail(ValidateEmailDto dto) {

        ValidateEmailResponseDto data = null;

        String email = dto.getEmail();

        try {
            
            boolean hasEamil = userRepository.existsByEmail(email);
            data = new ValidateEmailResponseDto(!hasEamil);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<ValidateNicknameResponseDto> validateNickname(ValidateNicknameDto dto) {

        ValidateNicknameResponseDto data = null;

        String nickname = dto.getNickname();

        try {
            
            boolean hasNickname = userRepository.existsByNickname(nickname);
            data = new ValidateNicknameResponseDto(!hasNickname);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<ValidateTelNumberResponseDto> validateTelNumber(ValidateTelNumberDto dto) {

        ValidateTelNumberResponseDto data = null;

        String telNumber = dto.getTelNumber();

        try {
            
            boolean hasTelNumber = userRepository.existsByTelNumber(telNumber);
            data = new ValidateTelNumberResponseDto(!hasTelNumber);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    //
    public ResponseDto<GetUserResponseDto> getUser(String email) {
        GetUserResponseDto data = null;

        try {

            UserEntity userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER);

            data = new GetUserResponseDto(userEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    

    

}
