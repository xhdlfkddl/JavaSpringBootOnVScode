package com.koreait.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.board.common.constant.ResponseMessage;
import com.koreait.board.dto.request.department.PostDepartmentRequestDto;
import com.koreait.board.dto.response.ResponseDto;
import com.koreait.board.dto.response.department.DeleteDepartmentResponseDto;
import com.koreait.board.dto.response.department.GetAllDepartmentListResponseDto;
import com.koreait.board.dto.response.department.PostDepartmentResponseDto;
import com.koreait.board.entity.DepartmentEntity;
import com.koreait.board.entity.EmployeeEntity;
import com.koreait.board.repository.DepartmentRepository;
import com.koreait.board.repository.EmployeeRepository;

@Service
public class DepartmentService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    // 새로운 부서 등록
    public ResponseDto<PostDepartmentResponseDto> postDepartment(PostDepartmentRequestDto dto) {
        
        PostDepartmentResponseDto data = null;

        // 입력한 부서번호가 이미 존재하는 부서번호인지
        String departmentCode = dto.getDepartmentCode();
        // 입력한 사번이 존재하는 사번인지
        int cheifemployeenumber = dto.getCheif();
        
        try {
            //입력한 부서번호가 이미 존재하는 부서번호라면
            boolean hasDepartment = departmentRepository.existsById(departmentCode);
            if (hasDepartment) return ResponseDto.setFail(ResponseMessage.EXIST_DEPARTMENT_CODE);

            boolean hasEmployee = employeeRepository.existsById(cheifemployeenumber);
            if (!hasEmployee) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_EMPLOYEE_NUMBER);

            EmployeeEntity employeeByCheif = employeeRepository.findByEmployeeNumber(cheifemployeenumber);
            String alreadyDepartment = employeeByCheif.getDepartment();
            if (alreadyDepartment != null) return ResponseDto.setFail(ResponseMessage.ALREADY_IN_CHARGE_OF_DEPARTMENT_HEAD);

            DepartmentEntity departmentEntity = new DepartmentEntity(dto);
            departmentRepository.save(departmentEntity);

            data = new PostDepartmentResponseDto(departmentEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    // 부서 전체 정보 조회
    public ResponseDto<List<GetAllDepartmentListResponseDto>> getAllDepartmentList() {
        // List는 interface라서 new 하지 못하고 ArrayList로 생성해야함
        List<GetAllDepartmentListResponseDto> data = new ArrayList<GetAllDepartmentListResponseDto>();

        try {
            
            // findAll = 전체 / retun 타입 = List<DepartmentEntity>
            List<DepartmentEntity> departmentList = departmentRepository.findAll();
            data = GetAllDepartmentListResponseDto.copyList(departmentList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    public ResponseDto<List<DeleteDepartmentResponseDto>> deleteDepartment(String departmentCode) {
        
        List<DeleteDepartmentResponseDto> data = null;

        try {
            
            // 부서코드 존재여부
            boolean hasDepartment = departmentRepository.existsById(departmentCode);
            if (!hasDepartment) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_DEPARTMENT_CODE);

            // 사원 테이블에서 입력한 departmentCode를 참조하고 있을 때
            boolean hasReferenceEmployee = employeeRepository.existsByDepartment(departmentCode);
            if (hasReferenceEmployee) return ResponseDto.setFail(ResponseMessage.REFERRING_TO_EXISTS);

            // 삭제
            departmentRepository.deleteById(departmentCode);

            List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
            data = DeleteDepartmentResponseDto.copyList(departmentEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
    
}
