package com.koreait.board.dto.request.humanResource;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostHumanResourceRequestDto {
    
    //? 직급
    @NotBlank // = 빈값 허용하지않음
    @Length(min= 0, max= 5) // = 길이값
    private String  position;

    //? 사원이름
    @NotBlank
    @Length(min = 0, max = 10)
    private String  name;

    //? 나이
    @Range(min = 0, max = 120)
    private int     age;

    //? 성별
    @NotBlank
    @Length(min = 0, max = 5)
    private String  gender;

    //? 학력
    @NotBlank
    @Length(min = 0, max = 10)
    private String  academicAbility;

    //? 생일
    @NotBlank
    private String  birth;

    //? 휴대전화번호
    @NotBlank
    private String  telNumber;

    //? 주소
    @NotBlank
    private String  address;

    //? 상세주소
    @NotBlank
    private String  addressDetail;

    //? 입사일
    @NotBlank
    private String  joinDate;

    //? 퇴사일
    private String  resignationDate;

    //? 부서 코드
    private String  department;

    //? 연봉
    @Min(0)
    private String  annualIncome;

    //? 비고
    private String  note;
}
