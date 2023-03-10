package com.koreait.board.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.board.common.constant.ApiMappingPattern;
import com.koreait.board.dto.request.department.PostDepartmentRequestDto;
import com.koreait.board.dto.response.ResponseDto;
import com.koreait.board.dto.response.department.DeleteDepartmentResponseDto;
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
    private static final String DELETE_DEPARTMENT = "/{departmentCode}";
    
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

    //Delete 메서드는 데이터를 URL에 담아서 전달함
    //? DLETE http://localhost:4040/apis/department/{departmentCode}
    @DeleteMapping(DELETE_DEPARTMENT)
    //PathVariable = react에서는 useParam과 같음
    public ResponseDto<List<DeleteDepartmentResponseDto>> deleteDepartment(@PathVariable("departmentCode") String departmentCode) {
        ResponseDto<List<DeleteDepartmentResponseDto>> response = departmentService.deleteDepartment(departmentCode);

        return response;
    }
}
