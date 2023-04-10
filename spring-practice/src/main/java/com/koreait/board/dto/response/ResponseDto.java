package com.koreait.board.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "set")
@NoArgsConstructor
public class ResponseDto<D> {
    //? Response의 결과 상태
    //? 정상: true, 비정상: false
    private boolean status;
    //? Response의 결과 메세지
    private String message;
    //? Response의 결과 데이터
    private D data;

    //? 생성자의 접근 제어자 = pubilc
    //# 성공시에 인스턴스를 생성해주는 static 생성자
    //? <D> ResponseDto<D>
    //? 앞에 있는 <D>는 해당 메서드에서 독립적으로 사용할 제너릭을 지칭
    //? 뒤에 있는 <D>는 ResponseDto 클래스 타입에 필요로 하는 제너릭을 지칭
    public static <D> ResponseDto<D> setSuccess(String message, D data) {
        return ResponseDto.set(true, message, data);
    }

    //# 실패 시에 인스턴스를 생성해주는 static 생성자 
    public static <D> ResponseDto<D> setFail(String message) {
        return ResponseDto.set(false, message, null);
    }
}
