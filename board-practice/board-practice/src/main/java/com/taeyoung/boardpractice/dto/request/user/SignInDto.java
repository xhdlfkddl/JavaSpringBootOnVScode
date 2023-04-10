package com.taeyoung.boardpractice.dto.request.user;

import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignInDto {

    @Id
    private String email;
    private String password;
    
}
