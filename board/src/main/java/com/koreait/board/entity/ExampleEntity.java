package com.koreait.board.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//# @Entity(name= "엔티티명")
//? = 데이터베이스 테이블에 상응하는 Entity class를 지정해주는 어노테이션
//? = ORM이 해당 어노테이션으로 작성된 class를 특정 테이블에 매핑되도록 해줌
//? = DB에 Example 테이블과 연결된 상태
@Entity(name= "Example")
//# @Table(name="테이블명")
//? = 해당 Entity의 테이블 명을 지정하기 위한 어노테이션
//? = 데이터베이스와 자바에서 사용하는 이름이 다를 때 사용
//? = @Table을 추가하지 않으면 @Entity의 엔터티명을 따라 테이블을 지정
@Table(name="Example")
//# @Builder 
//? = 빌더 패턴을 생성해주는 lombok 어노테이션
//? = 생성자로 특정한 필드를 지정하여 지정된 필드들만 초기화하는 것이 아니고,
//?   생성하는 순간 초기화할 필드를 저정하여 인스턴스를 생성해주는 패턴
//? = 사용방법: 클래스명.builder().필드명(초기화할 값)[...].build();
@Builder
public class ExampleEntity {
    //# @Id 
    //? = 해당 필드를 primary key로 지정
    @Id
    ///# @GeneratedValue(...)
    //? = entity에서 기본키 생성 전략
    //? = 필드의 값을 자동으로 생성해주기 위한 어노테이션
    //# strategy =  GenerationType.IDENTITY 
    //? = AUTO_INCREMENT 전략
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // DB에 있는 이름과 다르면 연결이 안됨
    private Integer prime;
    private String comment;
    private int number;
}
