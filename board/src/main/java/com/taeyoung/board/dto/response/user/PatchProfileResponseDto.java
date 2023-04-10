package com.taeyoung.board.dto.response.user;

import com.taeyoung.board.entity.UserEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "유저 프로필 URL 수정 Response Body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchProfileResponseDto {
    @ApiModelProperty(value = "사용자 이메일", example = "userEmail@google.com", required = true)
    private String email;

    @ApiModelProperty(value = "사용자 닉네임", example = "userNickname", required = true)
    private String nickname;
    
    @ApiModelProperty(value = "사용자 휴대전화번호", example = "010-0000-0000", required = true)
    private String telNumber;
    
    @ApiModelProperty(value = "사용자 주소", example = "김해시 00로 00번길", required = true)
    private String address;
    
    @ApiModelProperty(value = "사용자 프로필 URL", example = "http://userProfileImgUrl", required = false)
    private String profile;

    public PatchProfileResponseDto(UserEntity userEntity) {
        this.email = userEntity.getEmail();
        this.nickname = userEntity.getNickname();
        this.telNumber = userEntity.getTelNumber();
        this.address = userEntity.getAddress();
        this.profile = userEntity.getProfile();
    }
}
