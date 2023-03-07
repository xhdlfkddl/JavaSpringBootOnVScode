package com.koreait.board.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.koreait.board.dto.request.humanResource.PostHumanResourceRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Employee")
@Table(name = "Employee")
public class EmployeeEntity {
    @Id // = PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // = 자동생성, AUTO_INCREMENT
    //? 사번
    private int     employeeNumber;
    //? 직급
    private String  position;
    //? 사원이름
    private String  name;
    //? 나이
    private int     age;
    //? 성별
    private String  gender;
    //? 학력
    private String  academicAbility;
    //? 생일
    private String  birth;
    //? 휴대전화번호
    private String  telNumber;
    //? 주소
    private String  address;
    //? 상세주소
    private String  addressDetail;
    //? 입사일
    private String  joinDate;
    //? 퇴사일
    private String  resignationDate;
    //? 부서 코드
    private String  department;
    //? 연봉
    private String  annualIncome;
    //? 비고
    private String  note;

    // service에서 사용할 생성자
    public EmployeeEntity(PostHumanResourceRequestDto dto) {
        this.position = dto.getPosition();
        this.name = dto.getName();
        this.age = dto.getAge();
        this.gender = dto.getGender();
        this.academicAbility = dto.getAcademicAbility();
        this.birth = dto.getBirth();
        this. telNumber = dto.getTelNumber();
        this.address = dto.getAddress();
        this.addressDetail = dto.getAddressDetail();
        this.joinDate = dto.getJoinDate();
        this.resignationDate = dto.getResignationDate();
        this.department = dto.getDepartment();
        this.annualIncome = dto.getAnnualIncome();
        this.note = dto.getNote();
    }
}
