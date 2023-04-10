package com.taeyoung.boardpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.taeyoung.boardpractice.constant.ResponseMessage;
import com.taeyoung.boardpractice.dto.request.user.SignInDto;
import com.taeyoung.boardpractice.dto.request.user.SignupDto;
import com.taeyoung.boardpractice.dto.response.ResponseDto;
import com.taeyoung.boardpractice.dto.response.user.SignInResponseDto;
import com.taeyoung.boardpractice.dto.response.user.SignUpResponseDto;
import com.taeyoung.boardpractice.entity.UserEntity;
import com.taeyoung.boardpractice.provider.TokenProvider;
import com.taeyoung.boardpractice.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService{

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired private UserRepository userRepository;
    @Autowired private TokenProvider tokenProvider;
    
    //? SignUp
    @Override
    public ResponseDto<SignUpResponseDto> signUp(SignupDto dto) {
        SignUpResponseDto data = null;

        String email = dto.getEmail();
        String password = dto.getPassword();
        String telNumber = dto.getTelNumber();

        try {
            
            if (userRepository.existsByEmail(email)) return ResponseDto.setFail(ResponseMessage.EXIST_EMAIL);
            if (userRepository.existsByTelNumber(telNumber)) return ResponseDto.setFail(ResponseMessage.EXIST_TELNUMBER);

            String passwordEncode = passwordEncoder.encode(password);
            dto.setPassword(passwordEncode);

            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

            data = new SignUpResponseDto(true);

            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATA_BASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    //? SignIn
    @Override
    public ResponseDto<SignInResponseDto> signIn(SignInDto dto) {

        SignInResponseDto data = null;

        String email = dto.getEmail();
        String password = dto.getPassword();

        UserEntity userEntity = null;

        try {

            userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return ResponseDto.setFail(ResponseMessage.WRONG_USER_INFORMATION);
            
            System.out.println(userEntity);

            boolean isEqualPassword = passwordEncoder.matches(password, userEntity.getPassword());
            if (!isEqualPassword) return ResponseDto.setFail(ResponseMessage.WRONG_USER_INFORMATION);

            // String nickname = userEntity.getNickname();
            // String telNumber = userEntity.getTelNumber();
            // String address = userEntity.getAddress();
            // String profile = userEntity.getProfile();

            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATA_BASE_ERROR);
        }
        
        try {
            
            
            String token = tokenProvider.create(email);

            data = new SignInResponseDto(userEntity, token);
        
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.TOKEN_ERROR);
        }
        
        
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }
}
