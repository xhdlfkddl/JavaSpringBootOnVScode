package com.taeyoung.boardpractice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "set")
public class ResponseDto<D> {
    
    private boolean flag;
    private String message;
    private D data;

    public static <D> ResponseDto<D> setFail(String message) {
        return ResponseDto.set(false, message, null) ;
    }

    public static <D> ResponseDto<D> setSuccess(String message, D data) {
        return ResponseDto.set(true, message, data);
    }


}
