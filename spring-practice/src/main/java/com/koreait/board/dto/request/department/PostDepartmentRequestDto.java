package com.koreait.board.dto.request.department;

import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

// ReqDto는 AllArgsConstructor를 쓰지않음
@Data
@NoArgsConstructor
public class PostDepartmentRequestDto {
    
    @Id
    @NotBlank
    @Length(min = 0, max = 5)
    private String departmentCode;
    
    @NotBlank
    @Length(min = 0, max = 50)
    private String name;
    
    // int 타입에는 null이 올수 없기 때문에 @NotBlank 하지않음
    @Min(1)
    private int cheif;
    
    @NotBlank
    @Length(min = 0, max = 15)
    private String telNumber;
}
