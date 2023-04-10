package com.taeyoung.boardpractice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.taeyoung.boardpractice.dto.request.user.SignupDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="User")
@Table(name="User")
public class UserEntity {
    
    @Id
    private String email;
    private String password;
    private String nickname;
    private String telNumber;
    private String address;
    private String profile;

    public UserEntity(SignupDto dto) {
        this.email      = dto.getEmail();
        this.password   = dto.getPassword();
        this.nickname   = dto.getNickname();
        this.telNumber  = dto.getTelNumber();
        this.address    = dto.getAddress();
        this.profile    = dto.getProfile();
    }

}
