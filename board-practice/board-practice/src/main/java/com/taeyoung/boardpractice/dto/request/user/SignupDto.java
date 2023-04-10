package com.taeyoung.boardpractice.dto.request.user;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignupDto {
    
    @Id
    @NotBlank
    private String email;
    
    @NotBlank
    private String password;
    
    @NotBlank
    private String nickname;
    
    @NotBlank
    private String telNumber;
    
    @NotBlank
    private String address;
    
    private String profile;

}
