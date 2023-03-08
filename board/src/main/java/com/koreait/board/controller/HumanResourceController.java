package com.koreait.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.board.dto.response.ResponseDto;
import com.koreait.board.dto.response.humanResource.GetHumanResourceResponseDto;
import com.koreait.board.dto.response.humanResource.PatchHumanResourceResponseDto;
import com.koreait.board.dto.response.humanResource.PostHumanResourceResponseDto;
import com.koreait.board.service.HumanResourceService;
import com.koreait.board.common.constant.ApiMappingPattern;
import com.koreait.board.dto.request.humanResource.PatchHumanResourceRequestDto;
import com.koreait.board.dto.request.humanResource.PostHumanResourceRequestDto;

@RestController // = controller로 설정
@RequestMapping(ApiMappingPattern.HR) // = 특정한 주소를 입력하면 해당 컨드롤러가 실행되겠다고 설정
public class HumanResourceController { // = controller의 가장 중요한 두가지 client에게 받고, client에게 주는 것
    
    @Autowired private HumanResourceService humanResourceService;

    //
    private static final String POST_HUMAN_RESOURCE = "/";
    private static final String GET_HUMAN_RESOURCE = "/{employeeNumber}";
    private static final String PATCH_HUMAN_RESOURCE = "/";

    // 사원정보 등록
    //? POST http://localhost4040/apis/hr/
    @PostMapping(POST_HUMAN_RESOURCE)
    public ResponseDto<PostHumanResourceResponseDto> postHumanResource(@Valid @RequestBody PostHumanResourceRequestDto requestBody) { // @RequestBody = body를 읽어옴
        ResponseDto<PostHumanResourceResponseDto> response = humanResourceService.postHumanResource(requestBody);
        
        return response;
    }

    // 사원번호로 사원 조회
    // get에서는 ReqDto를 만들어줄 필요가 없음
    //? GET http://localhost4040/apis/hr/사원번호
    @GetMapping(GET_HUMAN_RESOURCE)
    public ResponseDto<GetHumanResourceResponseDto> getHumanResource(@PathVariable("employeeNumber") int employeeNumber) {
        ResponseDto<GetHumanResourceResponseDto> response = humanResourceService.getHumanResource(employeeNumber);

        return response;
    }

    // 사원 정보 수정
    // http 메서드 = PATCH
    // PATCH는 데이터를 받아올 때 body에서 받아옴
    // @Vaild가 없으면 유효성 검사를 할 수 없음
    //? PATCH http://localhost:4040/apis/hr/
    @PatchMapping(PATCH_HUMAN_RESOURCE)
    public ResponseDto<PatchHumanResourceResponseDto> patchHumanResource(@Valid @RequestBody PatchHumanResourceRequestDto reqsetBody) {
        ResponseDto<PatchHumanResourceResponseDto> response = humanResourceService.patchHumanResource(reqsetBody);

        return response;
    }

}
