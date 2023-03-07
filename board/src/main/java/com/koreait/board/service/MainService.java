package com.koreait.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.board.dto.GetTestResponseDto;
import com.koreait.board.dto.PostTestRequestDto;
import com.koreait.board.dto.response.ResponseDto;
import com.koreait.board.entity.ExampleEntity;
import com.koreait.board.repository.ExampleRepository;


//# Service 
//? 실제 비즈니스 로직을 담당하는 레이어
//? 일반적인 연산작업 
//? Controller로 사용자의 입력을 받아오면 
//? 해당 기능을 진행하기 위해 
//? Repository에서 데이터를 가져와서 작업을 진행함
@Service
public class MainService {

    @Autowired
    private ExampleRepository exampleRepository;

    public ResponseDto<String> getMain() {
        // return number + "Hello World";
        // return "Hello World";
        //? Dto 파일에 생성자가 StaticName으로 정해져있기 때문에
        //? 생성자 타입으로 생성할 수 없음
        // ResponseDto<String> result = new ResponseDto<String>
        // (true, "success", "Hello World");
        // ExampleEntity exampleEntity = new ExampleEntity(1, "Hello", 100);
        ExampleEntity exampleEntity = 
                ExampleEntity
                .builder()
                .comment("Hello")
                .number(1)
                .build();

        exampleRepository.save(exampleEntity);

        ResponseDto<String> result = 
			ResponseDto.setSuccess("success", "필승 Yes I can");
            // ResponseDto.setFail("Fail..");
        return result;
    }

    public ResponseDto<String> getVariable(String data) {
        // String string = "You input data is '" + data + "'";
        ExampleEntity exampleEntity = exampleRepository.findByComment(data);
        String string = exampleEntity.toString();

        ResponseDto<String> result= ResponseDto.setSuccess("Success", string);
        return result;
    }

    public ResponseDto<String> postMain() {
        ResponseDto<String> result = ResponseDto.setSuccess("Success", "POST main Response!");
        return result;
    }

    public ResponseDto<String> postRequestBody(String data) {
        String string = "Post body data is '" + data + "'.";
        ResponseDto<String> result = ResponseDto.setSuccess("Success", string);
        return result;
    }

    public ResponseDto<String> patchMain() {
        String string = "Patch 메서드는 수정 작업을 지정한 메서드입니다. 클라이언트로부터 데이터를 받을 땐 request body로 받습니다.";
        ResponseDto<String> result = ResponseDto.setSuccess("Success", string);
        return result;
    }
    
    public ResponseDto<String> deleteMain() {
        String string = "Delete 메서드는 삭제 작업을 지정한 메서드입니다. 클라이언트로부터 데이터를 받을 땐 path variable로 받습니다.";
        ResponseDto<String> result = ResponseDto.setSuccess("Success", string);
        return result;
    }

    public ResponseDto<String> postTest(PostTestRequestDto dto) {
        String string = dto.toString();
        ResponseDto<String> result = ResponseDto.setSuccess("Success", string);
        return result;
    }

    public ResponseDto<GetTestResponseDto> getTest() {
        GetTestResponseDto data = new GetTestResponseDto(10, "Commnet");
        ResponseDto<GetTestResponseDto> result = ResponseDto.setSuccess("Success", data);
        return result;
    }

    public void descriptionJpaMethod() {
        //# JpaRepository 기본 메서드 
        //! findById(PK).get();
        //? = 해당 테이블에서 PK를 기준으로 값을 검색한 결과를 반환
        ExampleEntity exampleEntity = exampleRepository.findById(0).get();
        
        //! findAll();
        //? = 해당 테이블에 모든 레코드 결과를 반환
        List<ExampleEntity> listEntity = exampleRepository.findAll(); 

        //! save(entityInstance);
        //? 해당 테이블에 특정 레코드를 삽입 또는 수정
        //? Primary Key를 기준으로 
        //? Primary Key에 해당하는 레코드가 없다면 '삽입'
        //? Primary Key에 해당하는 레코드가 있다면 '수정'
        exampleRepository.save(exampleEntity);

        //! existsById(PK);
        //? 해당 테이블에 Primary Key를 기준으로
        //? 레코드가 존재한다면 true
        //? 레코드가 존재한다면 false
        boolean hasentity = exampleRepository.existsById(0);

        //! deleteById(PK);
        //? 해당 테이블에 PK를 기준으로 특정 레코드를 삭제
        exampleRepository.deleteById(0);
    }
}