package com.koreait.board.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.board.common.constant.ApiMappingPattern;
import com.koreait.board.dto.request.department.PostDepartmentRequestDto;
import com.koreait.board.dto.response.ResponseDto;
import com.koreait.board.dto.response.department.PostDepartmentResponseDto;

@RestController
@RequestMapping(ApiMappingPattern.DEPARTMENT)
public class DepartmentController {

    private static final String POST_DEPARTMENT = "/";
    
    @PostMapping(POST_DEPARTMENT)
    public ResponseDto<PostDepartmentResponseDto> postDepartment(@Valid @RequestBody PostDepartmentRequestDto requestBody) {
        return null;
    }
}
