package com.koreait.board.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.board.common.constant.ApiMappingPattern;
import com.koreait.board.dto.request.department.PostDepartmentRequestDto;
import com.koreait.board.dto.response.ResponseDto;
import com.koreait.board.dto.response.department.GetAllDepartmentListResponseDto;
import com.koreait.board.dto.response.department.PostDepartmentResponseDto;
import com.koreait.board.service.DepartmentService;


@RestController
@RequestMapping(ApiMappingPattern.DEPARTMENT)
public class DepartmentController {
    
    @Autowired
    DepartmentService departmentService;

    private static final String POST_DEPARTMENT = "/";
    private static final String GET_ALL_DEPARTMENT_LIST = "/";
    
    //? POST http://localhost:4040/apis/department
    @PostMapping(POST_DEPARTMENT)
    public ResponseDto<PostDepartmentResponseDto> postDepartment(@Valid @RequestBody PostDepartmentRequestDto requestBody) {
        ResponseDto<PostDepartmentResponseDto> response = departmentService.postDepartment(requestBody);

        return response;
    }

    //? GET http://localhost:4040/apis/department
    @GetMapping(GET_ALL_DEPARTMENT_LIST)
    public ResponseDto<List<GetAllDepartmentListResponseDto>> getAllDepartmentList() {
        ResponseDto<List<GetAllDepartmentListResponseDto>> response = departmentService.getAllDepartmentList();

        return response;
    }

}
